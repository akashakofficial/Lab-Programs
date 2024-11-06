import java.util.Scanner;

public class CaesarCipher {
    private static final int SHIFT = 3;

    public static String encrypt(String plainText) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + SHIFT) % 26 + base);
            }

            encryptedText.append(ch);
        }
        return encryptedText.toString();
    }

    public static String decrypt(String cipherText) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base - SHIFT + 26) % 26 + base);
            }
            decryptedText.append(ch);
        }
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String encryptedText = encrypt(text);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }
}
