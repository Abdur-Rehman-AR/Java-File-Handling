package java_io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) {

        try {

            /*
             * The File class is used to get info about a file like its name, size and
             * is it exists, and to manage its existence (like creating or deleting it).
             */

            File obj = new File("File_1.txt");
            Scanner reader = new Scanner(obj); // Scanner is used to read the file
            while (reader.hasNextLine()) // .hasNextLine() is used to check if there is another line in the file to read
            {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();

            /*
             * specific type of file error in Java that happens when your program tries to
             * open or read a file that doesn't exist on your hard drive or is unreachable.
             */
        } catch (FileNotFoundException e) {
            System.out.println("An Error Happened.");

            /*
             * When an error happens, printStackTrace() method prints a detailed
             * history report to console screen telling you exactly what went wrong,
             * why it went wrong, and the exact line number where the mistake happened.
             */
            e.printStackTrace();
        }
    }
}