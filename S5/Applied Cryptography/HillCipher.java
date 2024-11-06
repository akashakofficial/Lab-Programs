import java.util.Scanner;

public class HillCipher {
    private static final int SIZE = 2;
    private static int[][] keyMatrix = new int[SIZE][SIZE];
    private static int[][] inverseKeyMatrix = new int[SIZE][SIZE];
    private static int[] messageVector = new int[SIZE];
    private static int[] cipherVector = new int[SIZE];

    private static int charToInt(char c) {
        return c - 'A';
    }

    private static void generateKeyMatrix(String key) {
        int k = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                keyMatrix[i][j] = charToInt(key.charAt(k++));
            }
        }
    }

    private static void calculateInverseMatrix() {
        int det = (keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0]) % 26;
        det = (det < 0) ? det + 26 : det;
        int invDet = findMultiplicativeInverse(det, 26);
        inverseKeyMatrix[0][0] = (keyMatrix[1][1] * invDet) % 26;
        inverseKeyMatrix[0][1] = (-keyMatrix[0][1] + 26) * invDet % 26;
        inverseKeyMatrix[1][0] = (-keyMatrix[1][0] + 26) * invDet % 26;
        inverseKeyMatrix[1][1] = (keyMatrix[0][0] * invDet) % 26;
    }

    private static int findMultiplicativeInverse(int det, int mod) {
        for (int i = 1; i < mod; i++) {
            if ((det * i) % mod == 1) return i;
        }
        return -1;
    }

    private static void processDigraph(String digraph, int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            messageVector[i] = charToInt(digraph.charAt(i));
        }
        for (int i = 0; i < SIZE; i++) {
            cipherVector[i] = 0;
            for (int j = 0; j < SIZE; j++) {
                cipherVector[i] += matrix[i][j] * messageVector[j];
            }
            cipherVector[i] = cipherVector[i] % 26;
        }
    }

    private static String transformMessage(String message, int[][] matrix) {
        StringBuilder result = new StringBuilder();
        if (message.length() % 2 != 0) {
            message += "X";
        }

        for (int i = 0; i < message.length(); i += SIZE) {
            String digraph = message.substring(i, i + SIZE);
            processDigraph(digraph, matrix);
            for (int j = 0; j < SIZE; j++) {
                result.append((char) (cipherVector[j] + 'A'));
            }
        }
        return result.toString();
    }

    public static String encrypt(String message, String key) {
        generateKeyMatrix(key);
        return transformMessage(message, keyMatrix);
    }

    public static String decrypt(String message, String key) {
        generateKeyMatrix(key);
        calculateInverseMatrix();
        return transformMessage(message, inverseKeyMatrix);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the plaintext : ");
        String message = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        System.out.print("Enter the key (4 characters): ");
        String key = sc.nextLine().toUpperCase();

        if (key.length() != 4) {
            System.out.println("Invalid key length! Key must be exactly 4 characters.");
            return;
        }

        String cipherText = encrypt(message, key);
        System.out.println("Encrypted message: " + cipherText);
        String decryptedText = decrypt(cipherText, key);
        System.out.println("Decrypted message: " + decryptedText);

        sc.close();
    }
}