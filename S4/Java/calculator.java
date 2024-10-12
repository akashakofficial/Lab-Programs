import java.awt.*;
import javax.swing.*;

class calculator
{
    public static void main(String args[])
    {
        JFrame f=new JFrame("Calculator");
        JTextField text=new JTextField(17);
        JButton one=new JButton("1");
        JButton two=new JButton("2");
        JButton three=new JButton("3");
        JButton add=new JButton("+");
        JButton four=new JButton("4");
        JButton five=new JButton("5");
        JButton six=new JButton("6");
        JButton sub=new JButton("-");
        JButton seven=new JButton("7");
        JButton eight=new JButton("8");
        JButton nine=new JButton("9");
        JButton mul=new JButton("*");

        JButton dot=new JButton(".");
        JButton zero=new JButton("0");
        JButton equal=new JButton("=");
        JButton div=new JButton("/");




        f.setSize(200,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        f.add(text);
        f.add(one);
        f.add(two);
        f.add(three);
        f.add(add);
        f.add(four);
        f.add(five);
        f.add(six);
        f.add(sub);
        f.add(seven);
        f.add(eight);
        f.add(nine);
        f.add(mul);
        f.add(dot);
        f.add(zero);
        f.add(equal);
        f.add(div);
    }
}