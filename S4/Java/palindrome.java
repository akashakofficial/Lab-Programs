import java.util.Scanner;

class palindrome
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string : ");
        String check=sc.nextLine();

        int flag=0;
        int len=check.length();

        for(int i=0;i<len/2;i++)
        {
            if(check.charAt(i)!=check.charAt(len-i-1))
            {
                flag=1;
                break;
            }
        }

        if(flag==0)
        {
            System.out.println(check+" is a Palindrome");
        }
        else
        {
            System.out.println(check+" is not a Palindrome");
        }
    }
}