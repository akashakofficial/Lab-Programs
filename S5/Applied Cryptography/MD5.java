
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string from the user
        System.out.print("Enter the text to hash: ");
        String input = scanner.nextLine();

        // Compute MD5 hash
        String hashedOutput = generateMD5Hash(input);
        System.out.println("MD5 Hash: " + hashedOutput);

        scanner.close();
    }

    public static String generateMD5Hash(String input) {
        try {
            // Create MD5 MessageDigest instance
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the hash
            byte[] hashBytes = md.digest(input.getBytes());

            // Convert hash bytes to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}


