import java.io.ByteArrayInputStream;
public class ByteArrayInputStreamExample {
    public static void main(String[] args) {

        /*
         * since this specific class cannot work with files but only with byte array
         * present in RAM, so we first create a String data and then convert it into
         * bytes Array and then it is loaded into RAM automatically. As, the moment 
         * you declare a variable or create an object in Java, it is instantly and 
         * automatically placed into your RAM by the JVM. Your computer's CPU cannot 
         * work with data directly from a hard drive, everything your program executes 
         * must live in the RAM to run.
         */

        String data = "I_am_Abdur_Rehman_and_I_am_learning_Java.";
        byte[] bytes = data.getBytes();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        // 1. check how many bytes are available to read

        System.out.println("Available Bytes to read: " + inputStream.available());

        // 2. Is this class supports to be marked

        System.out.println("can this file be marked: " + inputStream.markSupported());

        // 3. this skips the Array slots to be read

        System.out.println("Number of Elements skipped: " + inputStream.skip(2));

        // 4. current position marked

        inputStream.mark(3);

        // 5. these methods are done to check the simulation of mark and reset

        System.out.println("Element read after mark method: " + (char) inputStream.read() + (char) inputStream.read()
                + (char) inputStream.read());

        // 6. this method takes the position pointer backs to the place marked earlier

        inputStream.reset();

        // 7. this method reads the bytes present in the array

        int num = 0;

        while ((num = inputStream.read()) != -1) {
            System.out.print((char) num);
        }
    }
}