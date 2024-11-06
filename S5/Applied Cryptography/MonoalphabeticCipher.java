import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class MonoalphabeticCipher
{
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String KEY = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final Map<Character, Character> encryptionMap = new HashMap<>();
    private static final Map<Character, Character> decryptionMap = new HashMap<>();

    static {
        for (int i = 0; i < ALPHABET.length(); i++) {
            encryptionMap.put(ALPHABET.charAt(i), KEY.charAt(i));
            decryptionMap.put(KEY.charAt(i), ALPHABET.charAt(i));
        }
    }

    private static String transform(String text, Map<Character, Character> map) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(Character.isLetter(c) ? map.get(Character.toUpperCase(c)) : c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String plaintext = scanner.nextLine();

        String encryptedText = transform(plaintext, encryptionMap);
        String decryptedText = transform(encryptedText, decryptionMap);

        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
