import java.util.Scanner;
import java.util.StringTokenizer;

class token
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str=sc.nextLine();

        StringTokenizer st=new StringTokenizer(str," ");
        int sum=0;
        while(st.hasMoreTokens())
        {
            sum=sum+Integer.parseInt(st.nextToken());
        }
        System.out.println(sum);
    }
}