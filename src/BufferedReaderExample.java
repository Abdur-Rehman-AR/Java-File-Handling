import java.io.*;

public class BufferedReaderExample {

    public static void main(String[] args) {

        /*
         * Using try-with-resources will catch the errors, plus it will
         * automatically close the resources. FileReader is being used To read from
         * the hard drive and put the data into the buffer And the bufferedReader
         * is used to speed up the Process of reading data from the buffer.
         */

        try (
                FileReader f = new FileReader("File_1.txt");
                BufferedReader bf = new BufferedReader(f, 8192);) {

            // is mark feature supported by buffered Reader class

            System.out.println();
            System.out.println("Mark feature Supported: " + bf.markSupported());

            // marking the position

            int maxLimit = 3;
            bf.mark(maxLimit);
            System.out.println("Current position has been marked.");

            // using the read function

            System.out.print("Using read function text is: ");
            int i = 0;
            int num = 0;
            while (i < maxLimit && (num = bf.read()) != -1) {
                System.out.print((char) num);
                i++;
            }

            // reset the position to mark

            System.out.println();
            bf.reset();
            System.out.println("Position has been set to the previously marked one.");

            // using readLine function to read the whole lines

            System.out.println("Using readLine function text is: ");
            String data = "";

            while ((data = bf.readLine()) != null) {
                System.out.println(data);
            }

        } catch (IOException e) {

            System.out.println("Error happened: " + e.getMessage());
        }
    }
}