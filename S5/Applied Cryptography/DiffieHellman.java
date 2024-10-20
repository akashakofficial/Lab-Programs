import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger sharedSecret;
    private BigInteger prime;
    private BigInteger generator;
    private static final SecureRandom secureRandom = new SecureRandom();

    // Constructor to generate keys
    public DiffieHellman(BigInteger prime, BigInteger generator) {
        this.prime = prime;
        this.generator = generator;
        this.privateKey = new BigInteger(prime.bitLength() - 1, secureRandom); // Generate a private key
        this.publicKey = generator.modPow(privateKey, prime); // Calculate public key
    }

    // Method to generate shared secret
    public BigInteger generateSharedSecret(BigInteger otherPublicKey) {
        sharedSecret = otherPublicKey.modPow(privateKey, prime); // Calculate shared secret
        return sharedSecret;
    }

    public BigInteger getPublicKey() {
        return publicKey;
    }

    public BigInteger getSharedSecret() {
        return sharedSecret;
    }

    // Method to generate a random prime number of given bit length
    public static BigInteger generateRandomPrime(int bitLength) {
        return BigInteger.probablePrime(bitLength, secureRandom);
    }
	public static BigInteger generateRandomGenerator(BigInteger prime) {
        BigInteger generator;
        do {
            generator = new BigInteger(prime.bitLength(), secureRandom);
        } while (generator.compareTo(BigInteger.ONE) <= 0 || generator.compareTo(prime) >= 0);
        return generator;
    }
    public static void main(String[] args) {
        int bitLength = 128; // Size of the prime

        // Generate a random large prime and a generator
        BigInteger prime = generateRandomPrime(bitLength);
        System.out.println("prime number used :: " + prime);
        BigInteger generator = generateRandomGenerator(prime);
		System.out.println("generator :: " + generator);
       
        //public key = generator*private key* mod(prime)
       
        // Alice 
        DiffieHellman alice = new DiffieHellman(prime, generator);
        BigInteger alicePublicKey = alice.getPublicKey();
        System.out.println("Alice's Public Key: " + alicePublicKey);

        // Bob
        DiffieHellman bob = new DiffieHellman(prime, generator);
        BigInteger bobPublicKey = bob.getPublicKey();
        System.out.println("Bob's Public Key: " + bobPublicKey);

        // Generate shared secret
        BigInteger aliceSharedSecret = alice.generateSharedSecret(bobPublicKey);
        BigInteger bobSharedSecret = bob.generateSharedSecret(alicePublicKey);

        // Display the shared secret
        System.out.println("Alice's Shared Secret: " + aliceSharedSecret);
        System.out.println("Bob's Shared Secret: " + bobSharedSecret);

        // Verify that both shared secrets are equal
        if (aliceSharedSecret.equals(bobSharedSecret)) {
            System.out.println("Shared secrets match!");
        } else {
            System.out.println("Shared secrets do not match!");
        }
    }
}
