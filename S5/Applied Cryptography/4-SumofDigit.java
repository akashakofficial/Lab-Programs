import java.util.Scanner;
class exp4
{
	public static void main(String[] args)
	{
		int sum=0,num=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int number=sc.nextInt();
		int fact=1;
		for(int i=1;i<=number;i++)
		{
			fact=fact*i;
		}
		System.out.println("FACTORIAL : "+fact);
		
		while(fact!=0)
		{
			num=fact%10;
			fact=fact/10;
			sum=sum+num;
		}
		
		System.out.println("SUM OF DIGIT : "+sum);
	}
}
