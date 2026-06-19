import java.io.File;

public class DeleteFolder {
    public static void main(String[] args) {

        /*
         * The File class is used to get info about a file or folder like its name,
         * size,
         * is it exists and to manage its existence (like creating or deleting it).
         */

        File folder = new File("X:\\Self Project\\new");

        /*
         * The delete() method doesn't just delete a folder, it also returns a boolean
         * value (true or false) to tell you if the deletion actually worked. Also it
         * will only delete the folder if it is empty.
         */

        if (folder.delete())
            System.out.println("Folder " + folder.getName() + " deleted Successfully.");
        else
            System.out.println("Folder " + folder.getName() + " cannot be deleted.");
    }
}