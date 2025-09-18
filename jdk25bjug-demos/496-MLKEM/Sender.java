import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.KEM;
import javax.crypto.SecretKey;
import java.util.HexFormat;

public class Sender {
    public static void main(String[] args) throws Exception {
        // 1. Read receiver's public key from file
        byte[] encodedPub = Files.readAllBytes(Paths.get("public.key"));
        KeyFactory kf = KeyFactory.getInstance("ML-KEM");
        PublicKey pub = kf.generatePublic(new X509EncodedKeySpec(encodedPub));

        // 2. Encapsulate using the receiver's public key
        KEM kem = KEM.getInstance("ML-KEM");
        KEM.Encapsulator encaps = kem.newEncapsulator(pub);
        KEM.Encapsulated capsule = encaps.encapsulate();

        SecretKey senderSecret = capsule.key();
        byte[] encapsulation = capsule.encapsulation();

        // 3. Save encapsulation for the receiver
        Files.write(Paths.get("encapsulation.bin"), encapsulation);
        System.out.println("Sender: Encapsulation written to encapsulation.bin");

        // 4. Print the shared secret
        System.out.println("Sender: Shared secret = " +
                HexFormat.of().formatHex(senderSecret.getEncoded()));
    }
}

