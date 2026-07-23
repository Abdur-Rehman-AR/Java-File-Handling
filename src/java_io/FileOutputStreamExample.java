package java_io;

import java.io.*;

public class FileOutputStreamExample {

    public static void main(String[] args) {

        // Actual String that we have to store in the file.
        String data = "Abdur Rehman";

        // Array of type byte to hold the ascii value of each char of String
        byte[] arr = data.getBytes();

        // using try with resources to catch errors + automatic close method call
        try (FileOutputStream outputStream = new FileOutputStream("File_1.txt");) {
            outputStream.write(arr);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Error happened: " + e.getMessage());
        }
    }
}