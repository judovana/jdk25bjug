import java.security.*;
import java.security.spec.*;
import java.nio.file.*;
import java.util.Base64;

public class MLDsaVerifyDemo {
    public static void main(String[] args) throws Exception {
        // Read files
        String pubB64 = Files.readString(Path.of("ml_dsa_public.key")).trim();
        String sigB64 = Files.readString(Path.of("ml_dsa_signature.sig")).trim();
        String message = Files.readString(Path.of("ml_dsa_message.txt"));

        // Reconstruct PublicKey
        byte[] pubBytes = Base64.getDecoder().decode(pubB64);
        X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubBytes);
        PublicKey pub = KeyFactory.getInstance("ML-DSA").generatePublic(pubSpec);

        // Decode signature
        byte[] signature = Base64.getDecoder().decode(sigB64);

        // Verify signature
        Signature sig = Signature.getInstance("ML-DSA");
        sig.initVerify(pub);
        sig.update(message.getBytes("UTF-8"));
        boolean valid = sig.verify(signature);

        System.out.println("Signature valid: " + valid);
    }
}

