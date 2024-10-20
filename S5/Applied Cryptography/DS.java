import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class DS {
    public static void main(String[] args) throws Exception {
        // Generate a key pair (private and public keys)
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Read message to be signed from user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message to be signed: ");
        String message = scanner.nextLine();

        // Generate digital signature
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] digitalSignature = signature.sign();

        // Print the signature
        System.out.println("Digital Signature: " + Base64.getEncoder().encodeToString(digitalSignature));

        // Verify the digital signature
        signature.initVerify(publicKey);
        signature.update(message.getBytes());
        boolean isVerified = signature.verify(digitalSignature);

        // Output verification result
        System.out.println("Signature Verified: " + isVerified);
 
        scanner.close();
    }
}


