import javax.crypto.KDF;
import javax.crypto.SecretKey;
import javax.crypto.spec.HKDFParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HexFormat;

public class KDFDemo {
    public static void main(String[] args) throws Exception {
        // Step 1: Input Keying Material (IKM) – normally a shared secret
        byte[] ikm = "my-shared-secret".getBytes();

        // Step 2: Configure HKDF-SHA256 with salt and info
        AlgorithmParameterSpec params = HKDFParameterSpec.ofExtract()
                .addIKM(ikm)
                .addSalt("optional-salt".getBytes())
                .thenExpand("aes-usage".getBytes(), 16); // derive 16 bytes (AES-128)

        // Step 3: Derive key
        KDF hkdf = KDF.getInstance("HKDF-SHA256");
        SecretKey derivedKey = hkdf.deriveKey("AES", params);

        // Step 4: Show result
        System.out.println("Derived AES key = " +
                HexFormat.of().formatHex(derivedKey.getEncoded()));
    }
}
