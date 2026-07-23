package java_io;

import java.io.*;

public class BufferedOutputStreamExample {
    public static void main(String[] args) {

        /*
         * here we are using FileOutputStream to open the pipeline as
         * BufferedOutputStream
         * class can't work alone without any other OutputStream class.
         */

        try (FileOutputStream f = new FileOutputStream("File_1.txt");) {
            BufferedOutputStream outputStream = new BufferedOutputStream(f);

            // using a byte array to write data from array to internal buffer
            String data = "I am Cha eun woo ...";
            byte[] arr = data.getBytes();

            // write method to write all content from arr array to internal array in RAM
            outputStream.write(arr, 0, arr.length);

            // to transfer all data from internal buffer to actual file on disk
            outputStream.flush();
            System.out.println();
            System.out.println("Data got tranferred to file on hard disk.");

            /*
             * close method automatically pushes any leftover data trapped in the RAM
             * straight into the file + It shuts down the pipeline for FileOutputStream
             * completely.
             */

            outputStream.close();

        } catch (IOException e) {
            System.out.println("File not Found: " + e.getMessage());
        }
    }
}