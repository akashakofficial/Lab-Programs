import java.util.Scanner;
import java.io.*;

class write {
    public static void main(String args[]) {
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Do you want to add your name[1/0]: ");
            option = sc.nextInt();
            
            if (option == 1) {
                System.out.print("Enter Your Name: ");
                String text = sc.nextLine();
                try {
                    FileWriter fw = new FileWriter("name.txt", true); // append mode
                    fw.write("Name: " + text + "\n");
                    fw.close();
                    System.out.println("Name Added!");
                } catch (IOException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
        } while (option != 0);
    }
}
