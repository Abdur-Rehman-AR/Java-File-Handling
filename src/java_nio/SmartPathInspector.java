// It is a file auditing tool (program) that checks, examines, and reports 
// information about files and folders.

package java_nio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class SmartPathInspector {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // The program receives the messy file path

        System.out.print("Enter the path of file or folder: ");
        String loc = sc.nextLine();

        /*
         * 1. We will create object of this path.
         * Paths.get() is a static method of the Paths class. Its job is to create
         * and return a Path object from the given file or folder path.
         */

        Path path = Paths.get(loc);
        System.out.println("Original path: " + path);

        // 2. Normalizing the path, i.e, removing the unnecessary parts by using
        // the normalize() method.

        Path cleanPath = path.normalize();
        System.out.println("Path after cleaning: " + cleanPath);

        // 3. Convert to an absolute path

        Path absolutePath = cleanPath.toAbsolutePath();
        System.out.println("Absolute Path: " + absolutePath);

        // 4. Display information about the path

        // Is the path absolute?
        System.out.println("Is original path absolute ? " + path.isAbsolute());

        // Total number of elements in path
        System.out.println("Total number of elements in path: " + absolutePath.getNameCount());

        // Root of the path
        System.out.println("Root of the path is: " + path.getRoot());

        // Parent directory
        System.out.println("Parent of the file we want to search: " + path.getParent());

        // File name
        System.out.println("Name of the file we are Searching: " + path.getFileName());

        // First name element
        System.out.println("First folder in the directory is: " + path.getName(0));

        // Extract a subpath

        if (absolutePath.getNameCount() >= 2)
            System.out.println("First two folder of the path are: " + path.subpath(0, 2));
        else
            System.out.println("Path is too short to calculate sub-path");

        // 6. Check the file name

        System.out.print("Enter the File name to check, either it matches with current file: ");
        String endName = sc.nextLine();
        if (path.endsWith(endName))
            System.out.println("Yes, it matches");
        else
            System.out.println("No, It doesn't match.");

        // 7. Compare two paths

        System.out.print("Enter 2nd path: ");
        String loc2 = sc.nextLine();
        Path path2 = Paths.get(loc2);
        if (cleanPath.compareTo(path2.normalize()) == 0)
            System.out.println("Path same.");
        else
            System.out.println("Path different.");

        // 8. Convert Path to File
        File file = cleanPath.toFile();
        System.out.println("File name is: " + file.getName());

        // Preventing the resource leak
        sc.close();
    }
}