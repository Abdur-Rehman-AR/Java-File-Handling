import java.io.*;
public class ByteArrayOutputStreamExample {

    public static void main(String[] args) {

        // initialize the constructor with default size
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        /*
         * using an byte array as a buffer to store data, java first calculates the size
         * of the bytes that got converted from data variable and then uses this size to
         * give array the size.
         */
        String data = "I am Abdur Rehman ...";
        byte[] arr = data.getBytes();

        // using write method to write all content from arr array to byte array in RAM
        outputStream.write(arr, 0, arr.length);

        // Because this class cannot write to the file directly. So therefore we have 
        // to use FileOutputStream to start a pipeline and then write to the file. 

        System.out.println();
        
        try (FileOutputStream f = new FileOutputStream("File_1.txt");)
        {
            outputStream.writeTo(f);
            System.out.println("Write to file successfully.");
        } 
        catch (IOException e) 
        {
            System.out.println("File not Found: " +e.getMessage());
        }

        // getting the no. of bytes stored in array(internal buffer) in memory

        System.out.println("Size of bytes in Internal buffer is: " + outputStream.size());

        // to get all the data from the stream
        byte[] output = outputStream.toByteArray();
        System.out.print("All the data present in Output Stream: ");

        // using loop to get all the bytes
        for (byte b : output) {
            System.out.print(((char) b));
        }
        System.out.println();

        // Convert all bytes stored in the stream directly into a String.

        System.out.println("Elements from the internal buffer: " + outputStream.toString());

        // clearing the whole buffer to make it again reusable

        outputStream.reset();

    }
}