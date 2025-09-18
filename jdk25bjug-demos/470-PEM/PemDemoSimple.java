import java.security.*;
import java.util.Arrays;

import java.security.PEMEncoder;
import java.security.PEMDecoder;

public class PemDemoSimple {
    public static void main(String[] args) throws Exception {
        // Generate RSA keypair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        PublicKey pub = kp.getPublic();
        PrivateKey priv = kp.getPrivate();

        // create encoder and produce PEM strings
        PEMEncoder encoder = PEMEncoder.of();

        // PEM text as String
        String pubPem = encoder.encodeToString(pub);
        String privPem = encoder.encodeToString(priv);
        String kpPem = encoder.encodeToString(kp); // KeyPair encoded as PRIVATE KEY (OneAsymmetricKey)

        System.out.println("----- PUBLIC PEM -----");
        System.out.println(pubPem);
        System.out.println("----- PRIVATE PEM -----");
        System.out.println(privPem);
        System.out.println("----- KEYPAIR (OneAsymmetricKey) PEM -----");
        System.out.println(kpPem);

        // produce an encrypted private key PEM (password)
        char[] password = "s3cr3t".toCharArray();
        String encPrivPem = encoder.withEncryption(password).encodeToString(priv);
        System.out.println("----- ENCRYPTED PRIVATE PEM -----");
        System.out.println(encPrivPem);

        // decode back with PEMDecoder
        PEMDecoder decoder = PEMDecoder.of();

        PublicKey pubDecoded = decoder.decode(pubPem, PublicKey.class);
        PrivateKey privDecoded = decoder.decode(privPem, PrivateKey.class);
        Object decodedGeneric = decoder.decode(kpPem); // may return a KeyPair or DEREncodable

        System.out.println("pub .getEncoded() equals? " + Arrays.equals(pub.getEncoded(), pubDecoded.getEncoded()));
        System.out.println("priv .getEncoded() equals? " + Arrays.equals(priv.getEncoded(), privDecoded.getEncoded()));
        System.out.println("decoded keypair type: " + decodedGeneric.getClass().getName());

        // decode the encrypted private key by configuring decoder with password
        PrivateKey privDecodedEncrypted = decoder.withDecryption(password).decode(encPrivPem, PrivateKey.class);
        System.out.println("encrypted priv equals? " + Arrays.equals(priv.getEncoded(), privDecodedEncrypted.getEncoded()));
    }
}

