import java.nio.file.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.KDF;                       // JEP 510 KDF API
import javax.crypto.spec.HKDFParameterSpec;   // HKDF params
import java.util.HexFormat;

public class Receiver {
    public static void main(String[] args) throws Exception {
        // 1) Generate ML-KEM keypair and write public key
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("ML-KEM");
        kpg.initialize(NamedParameterSpec.ML_KEM_512);
        KeyPair kp = kpg.generateKeyPair();
        PublicKey pub = kp.getPublic();
        PrivateKey priv = kp.getPrivate();
        Files.write(Path.of("public.key"), pub.getEncoded());
        System.out.println("Receiver: public.key written. Press Enter after Sender runs.");
        System.in.read();

        // 2) Read encapsulation + ciphertext
        byte[] encapsulation = Files.readAllBytes(Path.of("encapsulation.bin"));
        byte[] ivPlusCt      = Files.readAllBytes(Path.of("ciphertext.bin"));

        // 3) Decapsulate shared secret
        KEM kem = KEM.getInstance("ML-KEM");
        KEM.Decapsulator dec = kem.newDecapsulator(priv);
        SecretKey shared = dec.decapsulate(encapsulation);

        // 4) Derive AES key via HKDF-SHA256 (16 bytes = AES-128)
        KDF hkdf = KDF.getInstance("HKDF-SHA256");
        AlgorithmParameterSpec params =
            HKDFParameterSpec.ofExtract()
                .addIKM(shared.getEncoded())
                .addSalt("kem-demo-salt".getBytes())
                .thenExpand("aes-key".getBytes(), 16);
        SecretKey aesKey = hkdf.deriveKey("AES", params);

        // 5) Split IV and ciphertext, then decrypt
        byte[] iv = new byte[16];
        System.arraycopy(ivPlusCt, 0, iv, 0, 16);
        byte[] ct = new byte[ivPlusCt.length - 16];
        System.arraycopy(ivPlusCt, 16, ct, 0, ct.length);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(iv));
        byte[] pt = cipher.doFinal(ct);

        System.out.println("Receiver: derived AES key = " +
                HexFormat.of().formatHex(aesKey.getEncoded()));
        System.out.println("Receiver: message = " + new String(pt, "UTF-8"));
    }
}

