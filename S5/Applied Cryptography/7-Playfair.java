import java.util.Scanner;

public class exp7
{

    private char[][] keyMatrix = new char[5][5];
    private String key;
    
    public exp7(String key)
    {
        this.key = prepareKey(key);
        createKeyMatrix();
    }

    private String prepareKey(String key)
    {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder preparedKey = new StringBuilder();
        boolean[] seen = new boolean[26];

        for (char c : key.toCharArray())
        {
            if (!seen[c - 'A']) {
                preparedKey.append(c);
                seen[c - 'A'] = true;
            }
        }
        
        for (char c = 'A'; c <= 'Z'; c++)
        {
            if (!seen[c - 'A'] && c != 'J')
            {
                preparedKey.append(c);
            }
        }

        return preparedKey.toString();
    }

    private void createKeyMatrix()
    {
        int index = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                keyMatrix[i][j] = key.charAt(index++);
            }
        }
    }

    private int[] findPosition(char letter)
    {
        if (letter == 'J') letter = 'I';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyMatrix[i][j] == letter)
                {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private String encryptPair(char a, char b)
    {
        int[] posA = findPosition(a);
        int[] posB = findPosition(b);

        if (posA[0] == posB[0])
        {
            return "" + keyMatrix[posA[0]][(posA[1] + 1) % 5] + keyMatrix[posB[0]][(posB[1] + 1) % 5];
        } else if (posA[1] == posB[1])
        {
            return "" + keyMatrix[(posA[0] + 1) % 5][posA[1]] + keyMatrix[(posB[0] + 1) % 5][posB[1]];
        } else 
        {
            return "" + keyMatrix[posA[0]][posB[1]] + keyMatrix[posB[0]][posA[1]];
        }
    }

    private String decryptPair(char a, char b) {
        int[] posA = findPosition(a);
        int[] posB = findPosition(b);

        if (posA[0] == posB[0])
        {
            return "" + keyMatrix[posA[0]][(posA[1] + 4) % 5] + keyMatrix[posB[0]][(posB[1] + 4) % 5];
        } else if (posA[1] == posB[1])
        {
            return "" + keyMatrix[(posA[0] + 4) % 5][posA[1]] + keyMatrix[(posB[0] + 4) % 5][posB[1]];
        } else
        {
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
            ciphertext.append(encryptPair(preparedText.charAt(i), preparedText.charAt(i + 1)));
        }

        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 2) {
            plaintext.append(decryptPair(ciphertext.charAt(i), ciphertext.charAt(i + 1)));
        }

        return plaintext.toString();
    }
    public void printKeyMatrix() {
        System.out.println("Key Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(keyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Key String : ");
        String key = scanner.nextLine();
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();
        exp7 exp7 = new exp7(key);
        String encryptedText = exp7.encrypt(plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = exp7.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
        scanner.close();
    }
}
