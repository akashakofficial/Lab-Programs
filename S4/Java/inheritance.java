import java.util.Scanner;

class employee
{
    private String name;
    private int age;
    private String phone;
    private String address;
    private int salary;

    public void printsalary()
    {
        System.out.print("Salary : "+salary);
    }

    public employee(String name,int age,String phone,String address,int salary)
    {
        this.name=name;
        this.age=age;
        this.phone=phone;
        this.address=address;
        this.salary=salary;
    }
    public void displayemployee()
    {
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("Phone : "+phone);
        System.out.println("Address : "+address);
        System.out.println("Salary : "+salary);
    }

}

class officer extends employee
{
    public String spec;
    public String dept;
    public officer(String name,int age,String phone,String address,int salary,String spec,String dept)
    {
        super(name,age,phone,address,salary);
        this.spec=spec;
        this.dept=dept;
    }
    public void displayofficer()
    {
        System.out.println("Officer Details");
        displayemployee();
        System.out.println("Specialization : "+spec);
        System.out.println("Department : "+dept);
    }
}

class manager extends employee
{
    public String spec;
    public String dept;
    public manager(String name,int age,String phone,String address,int salary,String spec,String dept)
    {
        super(name,age,phone,address,salary);
        this.spec=spec;
        this.dept=dept;
    }
    public void displaymanager()
    {
        System.out.println("Manager Details");
        displayemployee();
        System.out.println("Specialization : "+spec);
        System.out.println("Department : "+dept);
    }
}

class inheritance
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Officer details");
        System.out.print("Enter Name : ");
        String name=sc.nextLine();
        System.out.print("Enter Age : ");
        int age=sc.nextInt();sc.nextLine();
        System.out.print("Enter Phone number : ");
        String phone=sc.nextLine();
        System.out.print("Enter Address : ");
        String address=sc.nextLine();
        System.out.print("Enter Salary : ");
        int salary=sc.nextInt();sc.nextLine();
        System.out.print("Enter Specialization : ");
        String spec=sc.nextLine();
        System.out.print("Enter Department : ");
        String dept=sc.nextLine();

        officer off=new officer(name,age,phone,address,salary,spec,dept);
        off.displayofficer();

        System.out.println("Enter Manager details");
        System.out.print("Enter Name : ");
        name=sc.nextLine();
        System.out.print("Enter Age : ");
        age=sc.nextInt();sc.nextLine();
        System.out.print("Enter Phone number : ");
        phone=sc.nextLine();
        System.out.print("Enter Address : ");
        address=sc.nextLine();
        System.out.print("Enter Salary : ");
        salary=sc.nextInt();sc.nextLine();
        System.out.print("Enter Specialization : ");
        spec=sc.nextLine();
        System.out.print("Enter Department : ");
        dept=sc.nextLine();

        manager man=new manager(name,age,phone,address,salary,spec,dept);
        man.displaymanager();

    }
}
