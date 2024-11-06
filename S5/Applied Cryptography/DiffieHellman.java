import java.math.BigInteger; 
import java.security.SecureRandom;

public class DiffieHellman {

    public static void main(String[] args) {
        BigInteger p = new BigInteger(128, 100, new SecureRandom());
        BigInteger g = BigInteger.valueOf(2);

        BigInteger a = new BigInteger(128, new SecureRandom());
        BigInteger A = g.modPow(a, p);

        BigInteger b = new BigInteger(128, new SecureRandom());
        BigInteger B = g.modPow(b, p);

        BigInteger sharedSecretKeyAlice = B.modPow(a, p);
        BigInteger sharedSecretKeyBob = A.modPow(b, p);

        System.out.println("Prime number (p): " + p);
        System.out.println("Primitive root (g): " + g);
        System.out.println("Alice's private key (a): " + a);
        System.out.println("Alice's public key (A): " + A);
        System.out.println("Bob's private key (b): " + b);
        System.out.println("Bob's public key (B): " + B);
        System.out.println("Shared secret key computed by Alice: " + sharedSecretKeyAlice);
        System.out.println("Shared secret key computed by Bob: " + sharedSecretKeyBob);

        if (sharedSecretKeyAlice.equals(sharedSecretKeyBob)) {
            System.out.println("Shared secret keys match! The key exchange was successful.");
        } else {
            System.out.println("Shared secret keys do not match! There was an error in the exchange.");
        }
    }
}