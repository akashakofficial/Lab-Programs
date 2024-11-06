class XOR
{
	public static void main(String[]args)
	{
		int ascii;
		String input ="Hello World";
		String result="";
		int len=input.length();
		
		System.out.print("Result : ");
		for(int i=0;i<len;i++)
		{
			ascii=input.charAt(i)^0;
			System.out.print((char)ascii);
		}
		System.out.println("");
		
	}
}