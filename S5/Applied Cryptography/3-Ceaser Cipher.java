import java.util.Scanner;

public class exp3
{
    public static String encrypt(String plain, int shift)
    {
        StringBuilder encryptedText = new StringBuilder();
        
        for (int i = 0; i < plain.length(); i++)
        {
            char ch = plain.charAt(i);
            
            if (Character.isLetter(ch))
            {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            
            encryptedText.append(ch);
        }
        
        return encryptedText.toString();
    }
    
    public static String decrypt(String ciphertext, int shift) {
        return encrypt(ciphertext, 26 - shift);
    }
    
    public static void main(String[] args) {
        System.out.println("Encrypt/Decrypt");
        System.out.println("Encrypt :-0   Decrypt :- 1");
        Scanner scanner = new Scanner(System.in);
        int option=scanner.nextInt();
        scanner.nextLine();
        if(option == 0)
        {
            System.out.print("Enter the Text: ");
            String plaintext = scanner.nextLine();
            System.out.print("Shift Value: ");
            int shift = scanner.nextInt();
            String encryptedText = encrypt(plaintext, shift);
            System.out.print("Encrypted Text : " + encryptedText);
        }
        else if(option == 1)
        {   
            System.out.print("Enter the Cipher : ");
            String cipher=scanner.nextLine();
            System.out.print("Shift value : ");
            int shift = scanner.nextInt();
            String decryptedText = decrypt(cipher, shift);
            System.out.print("Decrypted Text: " + decryptedText);
        }
        scanner.close();
    }
}
