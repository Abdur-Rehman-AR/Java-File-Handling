package java_io;

import java.io.*;

public class BufferedInputStreamExample {
    public static void main(String[] args) {

        /*
         * using try with resources to handle exception as well as Stream closes
         * automatically + bufferedInputStream requires an inputStream object to
         * work so providing here we are.
         */

        try (InputStream in = new FileInputStream("File_1.txt");
                // using the constructor with default buffer size
                BufferedInputStream buffer = new BufferedInputStream(in);) {

            // how many bytes are present in buffer to read

            System.out.println();
            System.out.println("Bytes in buffer to read: " + buffer.available());

            // method to check either it supports mark feature or not

            if (buffer.markSupported())
                System.out.println("It supports mark feature.");
            else
                System.out.println("It does not support mark feature.");

            // print first two bytes

            System.out.println("" + (char) buffer.read() + ((char) buffer.read()));

            // mark the current position and tell how many more to read

            int readLimit = 6;
            buffer.mark(readLimit);
            System.out.println("Make a read limit of " + readLimit);

            // using a byte array to store that readlimit element

            System.out.print("The " + readLimit + " elements are as follow:");
            byte[] b = new byte[readLimit];
            buffer.read(b, 0, readLimit);

            for (byte i : b)
                System.out.print((char) i);
            System.out.println();

            // using to reset method to go back at the marked position.

            buffer.reset();
            System.out.println("We have now done reset.");

            System.out.println((char) buffer.read());

            // method to skip element from the buffer array

            System.out.println("Element skipped: " + buffer.skip(2));
            System.out.println((char) buffer.read());
        } catch (IOException e) {
            System.out.println("File is not Present.");
        }
    }
}