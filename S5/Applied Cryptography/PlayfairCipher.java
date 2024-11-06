import java.util.Scanner;

public class PlayfairCipher {
    private char[][] keyMatrix = new char[5][5];
    private String key;

    public PlayfairCipher(String key) {
        this.key = prepareKey(key);
        createKeyMatrix();
    }

    private String prepareKey(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder preparedKey = new StringBuilder();
        boolean[] seen = new boolean[26];

        for (char c : key.toCharArray()) {
            if (!seen[c - 'A']) {
                preparedKey.append(c);
                seen[c - 'A'] = true;
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (!seen[c - 'A'] && c != 'J') {
                preparedKey.append(c);
            }
        }
        return preparedKey.toString();
    }

    private void createKeyMatrix() {
        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyMatrix[i][j] = key.charAt(index++);
            }
        }
    }

    private int[] findPosition(char letter) {
        if (letter == 'J') letter = 'I';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyMatrix[i][j] == letter) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private String processPair(char a, char b, boolean isEncrypt) {
        int[] posA = findPosition(a), posB = findPosition(b);

        if (posA[0] == posB[0]) {
            return "" + keyMatrix[posA[0]][(posA[1] + (isEncrypt ? 1 : 4)) % 5]
                    + keyMatrix[posB[0]][(posB[1] + (isEncrypt ? 1 : 4)) % 5];
        } else if (posA[1] == posB[1]) {
            return "" + keyMatrix[(posA[0] + (isEncrypt ? 1 : 4)) % 5][posA[1]]
                    + keyMatrix[(posB[0] + (isEncrypt ? 1 : 4)) % 5][posB[1]];
        } else {
            return "" + keyMatrix[posA[0]][posB[1]] + keyMatrix[posB[0]][posA[1]];
        }
    }

    private String prepareText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder preparedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            preparedText.append(text.charAt(i));
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                preparedText.append('X');
            }
        }

        if (preparedText.length() % 2 != 0) {
            preparedText.append('X');
        }

        return preparedText.toString();
    }

    public String encrypt(String plaintext) {
        String preparedText = prepareText(plaintext);
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < preparedText.length(); i += 2) {
            ciphertext.append(processPair(preparedText.charAt(i), preparedText.charAt(i + 1), true));
        }

        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 2) {
            plaintext.append(processPair(ciphertext.charAt(i), ciphertext.charAt(i + 1), false));
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter key string (letters only): ");
        String key = scanner.nextLine();
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();

        PlayfairCipher cipher = new PlayfairCipher(key);
        String encryptedText = cipher.encrypt(plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = cipher.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }
}