import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) {

        try {
            File obj = new File("File_1.txt"); // file object is used to locate the file in hard drive
            Scanner reader = new Scanner(obj); // Scanner is used to read the file
            while (reader.hasNextLine()) // .hasNextLine() is used to check if there is another line in the file to read
            {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error Happened.");
            e.printStackTrace();
        }
    }
}