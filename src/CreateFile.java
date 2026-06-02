import java.io.File;
import java.io.IOException;

public class CreateFile {

    public static void main(String[] args) {

        try {
            File myfile = new File("File_1.txt");
            if (myfile.createNewFile()) {
                System.out.println("File Created: " + myfile.getName());
            } else {
                System.out.println("File already exits.");
            }
        } catch (IOException e) {
            System.out.println("An Error Happened.");
            e.printStackTrace();
        }
    }
}