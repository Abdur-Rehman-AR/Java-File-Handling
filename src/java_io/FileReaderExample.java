package java_io;

import java.io.*;

public class FileReaderExample {

    public static void main(String[] args) {

        // fileReader will create a pipeline from this java program to the file to read
        // file content.
        try (FileReader fileReader = new FileReader("File_1.txt");) {
            System.out.println();

            // Checks whether the stream is ready to be read.
            System.out.println("Is Stream ready to read data? " + fileReader.ready());

            // reading the characters from the file
            System.out.print("File content are as follow: ");
            int ch = 0;
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();

            // It tells type of encoding, FileReader is using to convert the file's bytes
            // into Java characters
            System.out.println("Type of encoding FileReader is using: " + fileReader.getEncoding());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}