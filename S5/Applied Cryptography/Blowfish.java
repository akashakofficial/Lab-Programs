import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class Blowfish
{
    public static String encrypt(String plainText, SecretKey key) throws Exception
    {
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String cipherText, SecretKey key) throws Exception
    {
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decryptedBytes);
    }

    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
            SecretKey secretKey = keyGenerator.generateKey();
            System.out.print("Enter the plaintext: ");
            String plainText = scanner.nextLine();
            String encryptedText = encrypt(plainText, secretKey);
            System.out.println("Encrypted Text: " + encryptedText);
            String decryptedText = decrypt(encryptedText, secretKey);
            System.out.println("Decrypted Text: " + decryptedText);
            scanner.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}