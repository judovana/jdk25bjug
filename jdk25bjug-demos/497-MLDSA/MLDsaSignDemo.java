import java.security.*;
import java.security.spec.*;
import java.nio.file.*;
import java.util.Base64;

public class MLDsaSignDemo {
    public static void main(String[] args) throws Exception {
        // Generate ML-DSA keypair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("ML-DSA");
        kpg.initialize(NamedParameterSpec.ML_DSA_44);
        KeyPair kp = kpg.generateKeyPair();
        PrivateKey priv = kp.getPrivate();
        PublicKey pub = kp.getPublic();

        // Message to sign
        byte[] message = "Hello Quantum World!".getBytes("UTF-8");

        // Sign the message
        Signature sig = Signature.getInstance("ML-DSA");
        sig.initSign(priv);
        sig.update(message);
        byte[] signature = sig.sign();

        // Write files (Base64 encoded)
        Files.writeString(Path.of("ml_dsa_public.key"), Base64.getEncoder().encodeToString(pub.getEncoded()));
        Files.writeString(Path.of("ml_dsa_signature.sig"), Base64.getEncoder().encodeToString(signature));
        Files.writeString(Path.of("ml_dsa_message.txt"), new String(message, "UTF-8"));

        System.out.println("Files written: ml_dsa_public.key, ml_dsa_signature.sig, ml_dsa_message.txt");
    }
}

