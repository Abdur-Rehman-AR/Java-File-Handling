import java.io.*;

public class StringReaderExample {
    public static void main(String[] args) {

        String str = "I am Abdur Rehman";

        // StringReader reads characters directly from the String stored in RAM.
        StringReader sr = new StringReader(str);

        /*
         * Because StringReader is a child of the Reader class. The parent Reader
         * class requires all read() implementations to include throws IOException
         * so they match up polymorphically, even if StringReader will practically
         * never experience a physical I/O error.
         */

        try {
            System.out.print("Text is: ");
            int num;
            while ((num = sr.read()) != -1) {
                System.out.print((char) num);
            }
        } catch (IOException e) {
            System.out.println("Error happened while reading the String.");
        }

        // is mark feature supported by buffered Reader class

        System.out.println();
        System.out.println("Mark feature Supported: " + sr.markSupported());

    }
}