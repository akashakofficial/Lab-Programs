import java.io.*;

class read
{
    public static void main(String args[])
    {
        try
        {
            FileReader fr=new FileReader("read.txt");
            int i;
            i=fr.read();
            do
            {
                System.out.print((char)i);
                i=fr.read();
            }
            while(i!=-1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}