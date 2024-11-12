import java.util.Scanner;

class RailFenceCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Message: ");
        String plaintext = sc.nextLine();
        System.out.print("Enter the Depth: ");
        int depth = sc.nextInt();

        String ciphertext = encrypt(plaintext, depth);
        System.out.println("Cipher Text: " + ciphertext);

        String decryptedText = decrypt(ciphertext, depth);
        System.out.println("Decrypted Text: " + decryptedText);

        sc.close();
    }

    public static String encrypt(String plaintext, int depth) {
        if (depth <= 1) {
            return plaintext;
        }

        char[][] rail = new char[depth][plaintext.length()];
        boolean goingDown = false;
        int row = 0, col = 0;

        for (char c : plaintext.toCharArray()) {
            rail[row][col++] = c;
            if (row == 0 || row == depth - 1) {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
        }

        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < plaintext.length(); j++) {
                if (rail[i][j] != 0) {
                    ciphertext.append(rail[i][j]);
                }
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int depth) {
        if (depth <= 1) {
            return ciphertext;
        }

        char[][] rail = new char[depth][ciphertext.length()];
        boolean goingDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < ciphertext.length(); i++) {
            rail[row][col++] = '*';
            if (row == 0 || row == depth - 1) {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
        }

        int index = 0;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < ciphertext.length(); j++) {
                if (rail[i][j] == '*' && index < ciphertext.length()) {
                    rail[i][j] = ciphertext.charAt(index++);
                }
            }
        }

        StringBuilder plaintext = new StringBuilder();
        row = 0;
        col = 0;
        goingDown = false;

        for (int i = 0; i < ciphertext.length(); i++) {
            plaintext.append(rail[row][col++]);
            if (row == 0 || row == depth - 1) {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
        }

        return plaintext.toString();
    }
}
