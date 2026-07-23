package java_io;

import java.io.*;

public class StringWriterExample {
    public static void main(String[] args) {

        // Initializing a StringWriter with an initial buffer capacity of 16 characters.
        // The buffer grows automatically if more space is needed.
        StringWriter sw = new StringWriter(16);

        // write() stores characters in the internal StringBuffer in RAM.
        sw.write("This is the drama. ");
        sw.write("I am the drama.");

        // toString() method is used to return the written string text
        System.out.println();
        System.out.println("Written in RAM successfully.");
        System.out.println("Text in RAM is: " + sw.toString());
    }
}