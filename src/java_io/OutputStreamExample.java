import java.io.*;

public class OutputStreamExample {
    public static void main(String[] args) {

        // a byte array whose data will be send to another file
        byte[] data = { 65, 66, 67, 68, 69 };

        // using try with resources to catch errors + automatic close method call
        try (OutputStream output = new FileOutputStream("File_1.txt");) {
            /*
             * write() writes bytes to the file. The file stores raw bytes.
             * When you open the file, the editor interprets those bytes
             * for example, using ASCII or UTF-8 and displays characters.
             */
            output.write(65);
            output.write(data, 2, 3);
            output.write(data);

            // if there remains any data in RAM send that all as well
            output.flush();

        } catch (IOException e) {
            System.out.println("Cannot find the file.");
        }
    }
}