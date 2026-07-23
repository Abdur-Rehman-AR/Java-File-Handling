package java_io;
import java.io.File;
import java.io.IOException;

public class CreateFile {

    public static void main(String[] args) {

        try {

            /*
             * The File class is used to get info about a file like its name, size and
             * is it exists, and to manage its existence (like creating or deleting it).
             */

            File myfile = new File("File_1.txt");

            /*
             * The createNewFile() method in File class is used to create a brand new
             * and empty file on your computer's hard drive, it returns a boolean value.
             * If the file did not exist before, Java creates it successfully and returns
             * true. If a file with that exact name already exists, Java will not overwrite
             * it or erase your data. It will safely leaves your old file alone and just
             * returns false.
             */
            if (myfile.createNewFile()) {
                System.out.println("File Created: " + myfile.getName());
            } else {
                System.out.println("File already exits.");
            }

            /*
             * IOException e catches any Input/Output errors that happen while your
             * program is talking to the hard drive.
             */

        } catch (IOException e) {
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