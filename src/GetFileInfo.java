import java.io.File;

public class GetFileInfo {

    public static void main(String[] args) {

        /*
         * The File class is used to get info about a file like its name, size and
         * is it exists, and to manage its existence (like creating or deleting it).
         */

        File obj = new File("File_1.txt");

        // to get extra information about a file we can use different methods

        if (obj.exists()) {
            System.out.println("File Name: " + obj.getName());
            System.out.println("File Path: " + obj.getAbsolutePath());
            System.out.println("Is file writeable? " + obj.canWrite());
            System.out.println("Is file readable? " + obj.canRead());
            System.out.println("File Size: " + obj.length());
        } else {
            System.out.println("File does not exists.");
        }
    }
}