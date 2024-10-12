import java.util.Scanner;

public class exp8
{
    public static String encrypt(String text, int key)
    {
        char[][] rail = new char[key][text.length()];
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < text.length(); j++)
            {
                rail[i][j] = '\n';
            }
        }
        boolean down = false;
        int row = 0, col = 0;
        for (int i = 0; i < text.length(); i++)
        {

            if (row == 0 || row == key - 1)
            {
                down = !down;
            }
            rail[row][col++] = text.charAt(i);
            row = down ? row + 1 : row - 1;
        }


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < text.length(); j++)
            {
                if (rail[i][j] != '\n')
                {
                    result.append(rail[i][j]);
                }
            }
        }
        return result.toString();
    }
    public static String decrypt(String cipherText, int key)
    {

        char[][] rail = new char[key][cipherText.length()];
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < cipherText.length(); j++)
            {
                rail[i][j] = '\n';
            }
        }
        boolean down = false;
        int row = 0, col = 0;

        for (int i = 0; i < cipherText.length(); i++)
        {
            if (row == 0 || row == key - 1) {
                down = !down;
            }
            rail[row][col++] = '*';
            row = down ? row + 1 : row - 1;
        }
        int index = 0;
        for (int i = 0; i < key; i++)
        {
            for (int j = 0; j < cipherText.length(); j++)
            {
                if (rail[i][j] == '*' && index < cipherText.length())
                {
                    rail[i][j] = cipherText.charAt(index++);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        row = 0;
        col = 0;
        down = false;

        for (int i = 0; i < cipherText.length(); i++)
        {
            if (row == 0 || row == key - 1) {
                down = !down;
            }

            result.append(rail[row][col++]);
            row = down ? row + 1 : row - 1;
        }
        return result.toString();
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the plaintext: ");
        String text = scanner.nextLine();
        System.out.print("Enter the depth : ");
        int key = scanner.nextInt();
        String cipherText = encrypt(text, key);
        System.out.println("Encrypted Text: " + cipherText);
        String decryptedText = decrypt(cipherText, key);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }
}
