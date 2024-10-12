class node
{
    int data;
    node rlink;
    node llink;

    public node(int data )
    {
        this.data=data;
        this.rlink=null;
        this.llink=null;
    }
}

class doubly
{
    node head;
    node tail;

    public void insert(int data)
    {
        node newnode=new node(data);
        if(head==null)
        {
            head=tail=newnode;
        }
        else
        {
            tail.rlink=newnode;
            newnode.llink=tail;
            tail=newnode;
        }
    }

    public void delete()
    {
        if(head==null)
        {
            System.out.println("List is empty!");
        }
        else
        {
            head=head.rlink;
            if(head!=null)
            {
                head.llink=null;
            }
            else
            {
                tail=null;
            }
        }
    }

    public void display()
    {
        node current=head;
        while(current!=null)
        {
            System.out.println(current.data);
            current=current.rlink;
        }

    }
}

public class dll
{
    public static void main(String args[])
    {
        doubly dll=new doubly();

        
        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.insert(5);
        dll.insert(6);

        dll.display();

        dll.delete();
        dll.display();

    }
}