class AND
{
	public static void main(String[]args)
	{
		int ascii;
		String input ="Hello World";
		String and="";
		String or="";
		String xor="";
		int len=input.length();
		
		System.out.print("AND : ");
		for(int i=0;i<len;i++)
		{
			ascii=input.charAt(i)&127;
			System.out.print((char)ascii);
		}
		System.out.println("");
		
		System.out.print("OR : ");
		for(int i=0;i<len;i++)
		{
			ascii=input.charAt(i)|127;
			System.out.print((char)ascii);
		}
		System.out.println("");
		
		System.out.print(" XOR : ");
		for(int i=0;i<len;i++)
		{
			ascii=input.charAt(i)^127;
			System.out.print((char)ascii);
		}
		System.out.println("");
		
	}
}
