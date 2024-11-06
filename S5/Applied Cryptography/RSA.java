import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.util.Base64;
import java.util.Scanner;

public class RSA
{
   public static String encrypt(String plaintext, PublicKey key)throws Exception{
         Cipher cipher= Cipher.getInstance("RSA");
         cipher.init(Cipher.ENCRYPT_MODE, key);
         byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
         return Base64.getEncoder().encodeToString(encryptedBytes);
    }
   public static String decrypt(String ciphertext, PrivateKey key) throws Exception {
         Cipher cipher = Cipher.getInstance("RSA");
         cipher.init(Cipher.DECRYPT_MODE, key);
         byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
         return new String(decryptedBytes);
    }
   public static void main(String args[]){
   try
   {
       Scanner scanner= new Scanner(System.in);
       KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
       keygen.initialize(512);
       KeyPair kp= keygen.generateKeyPair();
       PublicKey pk= kp.getPublic();
       PrivateKey prk= kp.getPrivate();
       System.out.print("Enter the plaintext:");
       String plainText = scanner.nextLine();
       String ciphertext=encrypt(plainText,pk);
       System.out.println("Encrypted text is:" + ciphertext);
       String decryptedtext= decrypt(ciphertext,prk);
       System.out.println("Decrypted text:"+decryptedtext);
   }catch(Exception e){
   e.printStackTrace();
   }
}
}