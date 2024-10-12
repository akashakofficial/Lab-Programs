import java.util.*;

class demo extends Thread
{
    public void run(int num)
    {
        num=num*num;
        System.out.println(num);
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}


class test extends Thread
{
    public void run()
    {
       
    }
}

class multi
{
    public static void main(String args[])
    {
        test t=new test();
        ddemo d=new test();
         for()
         {
            
         }
    }
}