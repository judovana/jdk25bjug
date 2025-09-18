import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.KEM;
import javax.crypto.SecretKey;
import java.util.HexFormat;

public class Receiver {
    public static void main(String[] args) throws Exception {
        // 1. Generate ML-KEM keypair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("ML-KEM");
        kpg.initialize(NamedParameterSpec.ML_KEM_512);
        KeyPair kp = kpg.generateKeyPair();

        PublicKey pub = kp.getPublic();
        PrivateKey priv = kp.getPrivate();

        // 2. Save the public key for the sender
        Files.write(Paths.get("public.key"), pub.getEncoded());
        System.out.println("Receiver: Public key saved to public.key");

        // 3. Keep private key in memory (not written to disk)
        System.out.println("Receiver: Waiting for encapsulation... (press Enter when ready)");
        System.in.read();

        // 4. Read encapsulation from file
        byte[] encapsulation = Files.readAllBytes(Paths.get("encapsulation.bin"));

        // 5. Decapsulate using private key
        KEM kem = KEM.getInstance("ML-KEM");
        KEM.Decapsulator decaps = kem.newDecapsulator(priv);
        SecretKey receiverSecret = decaps.decapsulate(encapsulation);

        System.out.println("Receiver: Decapsulated shared secret = " +
                HexFormat.of().formatHex(receiverSecret.getEncoded()));
    }
}

