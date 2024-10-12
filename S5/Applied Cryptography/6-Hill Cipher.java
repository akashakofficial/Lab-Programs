import java.util.Scanner;

public class exp6
{
    private static int[][] keyMatrix = new int[2][2];
    private static int[][] inverseKeyMatrix = new int[2][2];
    private static int[] messageVector = new int[2];
    private static int[] cipherVector = new int[2];
    private static void generateKeyMatrix(String key)
    {
        int k = 0;
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
    }

    private static void calculateInverseMatrix() {
        int determinant = (keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0]) % 26;
        if (determinant < 0) determinant += 26;
        int multiplicativeInverse = findMultiplicativeInverse(determinant, 26);

        inverseKeyMatrix[0][0] = keyMatrix[1][1] * multiplicativeInverse % 26;
        inverseKeyMatrix[0][1] = (-keyMatrix[0][1] + 26) * multiplicativeInverse % 26;
        inverseKeyMatrix[1][0] = (-keyMatrix[1][0] + 26) * multiplicativeInverse % 26;
        inverseKeyMatrix[1][1] = keyMatrix[0][0] * multiplicativeInverse % 26;
    }
    private static int findMultiplicativeInverse(int determinant, int mod)
    {
        for (int i = 1; i < mod; i++)
        {
            if ((determinant * i) % mod == 1)
            {
                return i;
            }
        }
        return -1;
    }
    private static void generateMessageVector(String message)
    {
        for (int i = 0; i < 2; i++)
        {
            messageVector[i] = (message.charAt(i)) % 65;
        }
    }
    private static void multiplyMatrix(int[][] matrix)
    {
        for (int i = 0; i < 2; i++)
        {
            cipherVector[i] = 0;
            for (int j = 0; j < 2; j++)
            {
                cipherVector[i] += matrix[i][j] * messageVector[j];
            }
            cipherVector[i] = cipherVector[i] % 26;
        }
    }

    private static String encryptPair(String digraph)
    {
        generateMessageVector(digraph);
        multiplyMatrix(keyMatrix);
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            cipherText.append((char) (cipherVector[i] + 65));
        }
        return cipherText.toString();
    }
    private static String decryptPair(String digraph)
    {
        generateMessageVector(digraph);
        multiplyMatrix(inverseKeyMatrix);
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            plainText.append((char) (cipherVector[i] + 65));
        }
        return plainText.toString();
    }
    public static String encrypt(String message, String key)
    {
        generateKeyMatrix(key);
        StringBuilder encryptedMessage = new StringBuilder();
        
        if (message.length() % 2 != 0) {
            message += "X";
        }

        for (int i = 0; i < message.length(); i += 2)
        {
            String digraph = message.substring(i, i + 2);
            encryptedMessage.append(encryptPair(digraph));
        }
        return encryptedMessage.toString();
    }


    public static String decrypt(String message, String key)
    {
        generateKeyMatrix(key);
        calculateInverseMatrix();
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i += 2)
        {
            String digraph = message.substring(i, i + 2);
            decryptedMessage.append(decryptPair(digraph));
        }
        return decryptedMessage.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter the plaintext: ");
        String message = sc.nextLine().toUpperCase();
        System.out.print("Enter the key (4 chars): ");
        String key = sc.nextLine().toUpperCase();

        if (key.length() != 4)
        {
            System.out.println("Invalid key length!");
            return;
        }


        String cipherText = encrypt(message, key);
        System.out.println("Encrypted message: " + cipherText);
        String decryptedText = decrypt(cipherText, key);
        System.out.println("Decrypted message: " + decryptedText);

        sc.close();
    }
}
