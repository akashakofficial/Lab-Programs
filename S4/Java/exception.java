import java.util.Scanner;

class exception
{
    public static void div(int x,int y) throws Exception
    {
        if(y==0)
        {
            throw new Exception("Division not possible");
        }
        else
        {
            int r=x/y;
            System.out.println("Result : "+r);
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two numbers");
        int x=sc.nextInt();sc.nextLine();
        int y=sc.nextInt();sc.nextLine();

        try
        {
            div(x,y);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}