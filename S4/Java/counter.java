import java.util.Scanner;

class counter
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str=sc.nextLine();
        System.out.print("Enter the Character : ");
        char ch=sc.next().charAt(0);
        int len=str.length();

        int count=0;
        for(int i=0;i<len;i++)
        {
            if(str.charAt(i)==ch)
            {
                count++;
            }
        }
        System.out.println("Character "+ch+" repeat "+count+" times");
    }
}
