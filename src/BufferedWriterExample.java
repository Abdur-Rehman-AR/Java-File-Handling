import java.io.*;

public class BufferedWriterExample {
    public static void main(String[] args) {

        /*
         * try with resources closes the resources at the end + catches the errors
         * FileWriter creates the stream while BufferedWriter creates the stream till
         * the Internal buffer.
         */
        try (FileWriter fw = new FileWriter("File_1.txt");) {

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Abdur Rehman");
            bw.newLine(); // creates a new line and next text start from next line
            bw.write("I am rich.");

            bw.flush(); // transfer all the data from buffer to file

            System.out.println("successfully written to the file.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}