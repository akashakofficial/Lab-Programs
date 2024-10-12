import javax.swing.*;
import java.awt.*;

class swing
{
    public static void main(String args[])
    {
        JFrame f=new JFrame("Swing");
        JLabel l=new JLabel("Enter the Data : ");
        JTextField t=new JTextField(20);
        JButton b=new JButton("Enter");
        JRadioButton r=new JRadioButton("male");
        String country[]={"India","Japan","Russia","Colombia"};
        JComboBox cb=new JComboBox(country);
        JCheckBox cbox=new JCheckBox();


        f.setSize(400,250);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        f.add(l);
        f.add(t);
        f.add(b);
        f.add(r);
        f.add(cb);

    }
}