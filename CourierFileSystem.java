import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CourierFileSystem {

    static File file = new File("courier.txt");

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ch = 0;

        while (true) {
            try {
                System.out.println("\n1.Create  2.Write  3.Append  4.Read  5.Delete  6.Exit");
                System.out.print("Enter choice: ");
                ch = sc.nextInt();
                sc.nextLine();

                if (ch == 6) {
                    System.out.println("Exit Finished. Program Terminated.");
                    break;   // program stops here
                }

                switch (ch) {

                    case 1:
                        if (file.createNewFile())
                            System.out.println("File Created");
                        else
                            System.out.println("File Already Exists");
                        break;

                    case 2:
                        try (FileWriter fw = new FileWriter(file)) {
                            System.out.print("Tracking ID: ");
                            fw.write("ID: " + sc.nextLine() + "\n");
                            System.out.print("Status: ");
                            fw.write("Status: " + sc.nextLine() + "\n");
                            System.out.println("Written");
                        }
                        break;

                    case 3:
                        try (FileWriter fw = new FileWriter(file, true)) {
                            System.out.print("Tracking ID: ");
                            fw.write("ID: " + sc.nextLine() + "\n");
                            System.out.print("Status: ");
                            fw.write("Status: " + sc.nextLine() + "\n");
                            System.out.println("Appended");
                        }
                        break;

                    case 4:
                        try (Scanner r = new Scanner(file)) {
                            while (r.hasNextLine())
                                System.out.println(r.nextLine());
                        }
                        break;

                    case 5:
                        if (file.exists() && file.delete())
                            System.out.println("File Deleted");
                        else
                            System.out.println("File Not Found");
                        break;

                    default:
                        System.out.println("Error: Invalid Option! Program supports only 1 to 6");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter numeric values only");
                sc.nextLine();
            } catch (IOException e) {
                System.out.println("File Error Occurred");
            }
        }

        sc.close();
    }
}
