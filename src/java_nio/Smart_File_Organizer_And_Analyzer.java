// Scenario
// You are developing a Smart File Organizer for a company. The program receives the path 
// of a folder from the user. It then analyzes every file, displays useful information, 
// organizes the files into folders based on their extensions, and finally generates a 
// summary report.

package java_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.stream.Stream;

public class Smart_File_Organizer_And_Analyzer {

    // Step 1: Get Folder
    // Ask the user to enter the folder path.

    private static Scanner sc = new Scanner(System.in);

    private static String getFolder() {
        System.out.print("Enter folder path: ");
        return sc.nextLine();
    }

    // Step 2: Validate Folder. Check:

    private static void validateFolder(Path folder) {
        // Does it exist?
        if (Files.exists(folder)) {
            System.out.println("Does it exist? YES");
        } else {
            System.out.println("Does it exist? NO");
            System.out.println("Terminating the program...");
            System.exit(1);
        }

        // Is it really a directory?
        if (Files.isDirectory(folder)) {
            System.out.println("Is it really a directory? YES");
        } else {
            System.out.println("Is it really a directory? NO");
            System.out.println("Terminating the program...");
            System.exit(1);
        }

        // Is it readable?
        if (Files.isReadable(folder)) {
            System.out.println("Is it readable? YES");
        } else {
            System.out.println("Is it readable? NO");
            System.out.println("Terminating the program...");
            System.exit(1);
        }

        // Is it writable?
        if (Files.isWritable(folder)) {
            System.out.println("Is it writable? YES");
        } else {
            System.out.println("Is it writable? NO");
            System.out.println("Terminating the program...");
            System.exit(1);
        }
    }

    // Step 3: List Files

    private static Stream<Path> getFiles(Path folder) {
        try {
            return Files.list(folder);
        } catch (Exception e) {
            System.out.println("An unexpected error happened.");
            return Stream.empty();
        }
    }

    // Step 4: Analyze Each File.

    private static void eachFileInfo(Path folder) {

        try {
            Files.walk(folder).forEach(p -> {
                if (Files.isRegularFile(p)) {
                    System.out.println();
                    System.out.println("File name: " + p.getFileName());
                    try {
                        System.out.println("File size: " + Files.size(p));
                        System.out.println("Last date Modified: " + Files.getLastModifiedTime(p));
                        BasicFileAttributes attr = Files.readAttributes(folder, BasicFileAttributes.class);
                        System.out.println("File creation time: " + attr.creationTime());
                        System.out.println("Last access time of File: " + attr.lastAccessTime());
                    } catch (IOException e) {
                        System.out.println("Unexpected error happened.");
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Unexpected Error Happened.");
        }
    }

    // Step 5: Read File Content (Only Text Files)

    public static Stream<Path> readFileContent(Path folder) {

        // Walk through all the files and select only regular text files
        try {
            return Files.walk(folder).filter(p -> Files.isRegularFile(p));
        } catch (Exception e) {
            System.out.println("Unexpected Error happened while reading the Files.");
        }
        return Stream.empty();
    }

    // Step 6: Create Category Folders, such as:
    // PDF
    // TEXT
    // IMAGES
    // VIDEOS
    // MUSIC
    // JAVA
    // OTHER

    

    // main method
    public static void main(String[] args) {

        System.out.println();
        System.out.println("******************** Smart File Organizer And Analyzer ********************");

        // 1. Taking input of folder
        String folder = getFolder();

        // path object represents the location of folder
        Path path = Paths.get(folder);

        // 2. Validating the folder
        validateFolder(path);
        System.out.println("So, folder is valid.");
        System.out.println();

        // 3. Files inside the folder
        Stream<Path> stream = getFiles(path);
        stream.forEach(p -> {
            System.out.println(p.getFileName());
        });
        System.out.println();

        // 4. Getting each Regular file info
        eachFileInfo(path);
        System.out.println();

        // 5. Read the text files

        boolean found = false;
        Stream<Path> list = readFileContent(path);

        // Showing the text files
        if (list.count() == 0) {
            System.out.println("There's no Text file in the folder.");
        } else {
            System.out.println("Text files are as follow: ");
            list.forEach(p -> System.out.println(p.getFileName()));

            // Input for file to see the content
            System.out.print("Please enter the file name to see its content: ");
            String textFile = sc.nextLine();

            // check either file entered by user is correct or not.

            for (Path p : list.toList()) {
                if (p.getFileName().toString().equals(textFile)) {
                    try {
                        Files.readString(p);
                        found = true;
                        break;
                    } catch (Exception e) {
                        System.out.println("Error happened while reading the file content.");
                    }
                }
            }
            if (!found) {
                System.out.println("File with name " + textFile + " does not exists.");
            }
        }

        // Step 7 — Move Files

        // Move each file into its correct folder.

        // Use:

        // Files.move()
        // Step 8 — Create a Report File

        // Create

        // Report.txt

        // inside the root folder.

        // Use:

        // Files.createFile()
        // Step 9 — Write Report

        // Write information such as:

        // Total files : 15

        // PDF : 4

        // TEXT : 3

        // JAVA : 2

        // Moved Successfully : 15

        // Use

        // Files.writeString()

        // or

        // Files.write()
        // Step 10 — Backup Report

        // Copy

        // Report.txt

        // to

        // Backup_Report.txt

        // Use

        // Files.copy()
        // Step 11 — Create Temporary File

        // Create a temporary log file.

        // Use

        // Files.createTempFile()

        // Write

        // Program executed successfully.
        // Step 12 — Delete Temporary File

        // Delete it after the program finishes.

        // Use

        // Files.deleteIfExists()
        // Step 13 — Final Summary

        // Display

        // Folders Created : 7

        // Files Processed : 15

        // Files Moved : 15

        // Report Generated : Yes

        // Backup Created : Yes

        // Program Finished Successfully.
    }
}