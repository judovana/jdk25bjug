import java.nio.file.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.KDF;                       // JEP 510 KDF API
import javax.crypto.spec.HKDFParameterSpec;   // HKDF params
import java.util.HexFormat;

public class Sender {
    public static void main(String[] args) throws Exception {
        // 1) Load receiver's public key
        byte[] pubBytes = Files.readAllBytes(Path.of("public.key"));
        PublicKey pub = KeyFactory.getInstance("ML-KEM")
            .generatePublic(new X509EncodedKeySpec(pubBytes));

        // 2) Encapsulate to get (shared secret, encapsulation)
        KEM kem = KEM.getInstance("ML-KEM");
        KEM.Encapsulator enc = kem.newEncapsulator(pub);
        KEM.Encapsulated cap = enc.encapsulate();
        SecretKey shared = cap.key();
        byte[] encapsulation = cap.encapsulation();
        Files.write(Path.of("encapsulation.bin"), encapsulation);

        // 3) Derive AES key via HKDF-SHA256 (same params as receiver)
        KDF hkdf = KDF.getInstance("HKDF-SHA256");
        AlgorithmParameterSpec params =
            HKDFParameterSpec.ofExtract()
                .addIKM(shared.getEncoded())
                .addSalt("kem-demo-salt".getBytes())
                .thenExpand("aes-key".getBytes(), 16);
        SecretKey aesKey = hkdf.deriveKey("AES", params);

        // 4) Encrypt a message with AES/CBC/PKCS5Padding
        String msg = "Hello from Sender via ML-KEM + HKDF + AES!";
        byte[] iv = SecureRandom.getInstanceStrong().generateSeed(16);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(iv));
        byte[] ct = cipher.doFinal(msg.getBytes("UTF-8"));

        // 5) Write IV + ciphertext for the receiver
        byte[] out = new byte[16 + ct.length];
        System.arraycopy(iv, 0, out, 0, 16);
        System.arraycopy(ct, 0, out, 16, ct.length);
        Files.write(Path.of("ciphertext.bin"), out);

        System.out.println("Sender: derived AES key = " +
                HexFormat.of().formatHex(aesKey.getEncoded()));
        System.out.println("Sender: wrote encapsulation.bin and ciphertext.bin");
    }
}

