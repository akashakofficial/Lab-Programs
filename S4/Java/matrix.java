import java.util.Scanner;

class matrix
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("MATRIX 1");
        System.out.print("Enter the number of Row : ");
        int r1=sc.nextInt();sc.nextLine();
        System.out.print("Enter the number of Column : ");
        int c1=sc.nextInt();sc.nextLine();

        System.out.println("MATRIX 2");
        System.out.print("Enter the number of Row : ");
        int r2=sc.nextInt();sc.nextLine();
        System.out.print("Enter the number of Column : ");
        int c2=sc.nextInt();sc.nextLine();

        int m1[][]=new int [r1][c1];
        int m2[][]=new int [r2][c2];

        if(r1!=c2)
        {
            System.out.println("Multiplication Not Possible");
        }
        else
        {
            System.out.println("ENTER MATRIX 1");
            for(int i=0;i<r1;i++)
            {
                for(int j=0;j<c1;j++)
                {
                    m1[i][j]=sc.nextInt();sc.nextLine();
                }
            }

            System.out.println("ENTER MATRIX 2");
            for(int i=0;i<r2;i++)
            {
                for(int j=0;j<c2;j++)
                {
                    m2[i][j]=sc.nextInt();sc.nextLine();
                }
            }

            int m3[][]=new int [10][10];
            for(int i=0;i<r1;i++)
            {
                for(int j=0;j<c2;j++)
                {
                    m3[i][j]=0;
                    for(int k=0;k<c1;k++)
                    {
                        m3[i][j]=m3[i][j]+m1[i][k]*m2[k][j];
                    }
                }
            }

            System.out.println("RESULTANT MATRIX");
            for(int i=0;i<r1;i++)
            {
                for(int j=0;j<c2;j++)
                {
                    System.out.print(m3[i][j]+"   ");
                }
                System.out.println();
            }




        }
    }
}