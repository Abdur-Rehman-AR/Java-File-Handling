package java_io;
import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {

        /*
         * The File class is used to get info about a file like its name, size and
         * is it exists, and to manage its existence (like creating or deleting it).
         */

        File file = new File("File_1.txt");

        /*
         * The delete() method doesn't just delete a file, it also returns a boolean
         * value (true or false) to tell you if the deletion actually worked.
         */

        if (file.delete())
            System.out.println("File " + file.getName() + " deleted Successfully.");
        else
            System.out.println("File " + file.getName() + " cannot be deleted.");

    }
}