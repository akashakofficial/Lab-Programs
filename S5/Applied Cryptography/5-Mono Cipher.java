import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
class exp5
{
	public static final String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String key="QWERTYUIOPASDFGHJKLZXCVBNM";
	
	public static Map<Character,Character> encryptionMap;
	public static Map<Character,Character> decryptionMap;
	
	static
	{
		encryptionMap = new HashMap<>();
		decryptionMap = new HashMap<>();
		
		for(int i=0;i<alphabet.length();i++)
		{
			encryptionMap.put(alphabet.charAt(i),key.charAt(i));
			decryptionMap.put(key.charAt(i),alphabet.charAt(i));
		}
	}
	
	public static String encrypt(String plaintext)
	{
		StringBuilder ciphertext=new StringBuilder();
		for(char c: plaintext.toCharArray())
		{
			if(Character.isLetter(c))
			{
				ciphertext.append(encryptionMap.get(Character.toUpperCase(c)));
			}
			else
			{
				ciphertext.append(c);
			}
		}
		return ciphertext.toString();
	}
	
	public static String decrypt(String ciphertext)
	{
		StringBuilder plaintext=new StringBuilder();
		for(char c: ciphertext.toCharArray())
		{
			if(Character.isLetter(c))
			{
				plaintext.append(decryptionMap.get(Character.toUpperCase(c)));
			}
			else
			{
				plaintext.append(c);
			}
		}
		return plaintext.toString();
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the Word : ");
		String plaintext = sc.nextLine();
		
		String ciphertext = encrypt(plaintext);
		plaintext = decrypt(ciphertext);
		
		System.out.println("ENCRYPTED TEXT : " + ciphertext);
		System.out.println("DECRYPTED TEXT : " + plaintext);
	}
}





