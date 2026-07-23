import java.io.*;

public class FileInputStreamExample {
    public static void main(String[] args) {

        // giving the file name to the FileInputStream constructor
        try (FileInputStream file = new FileInputStream("File_1.txt")) {

            /*
             * 1. getChannel() method returns a FileChannel object which is simply another
             * way to work with a file. FileChannel can read large files more efficiently.
             */

            System.out.println();
            System.out.println("Channel name: " + file.getChannel());

            /*
             * 2. When we open a file, OS gives a low-level identifier for the opened file,
             * that is actually the FileDescriptor object, getFD() method do this.
             */

            System.out.println("File Descriptor: " + file.getFD());

            // 3. this method tells how many bytes are left in file to be read

            System.out.println("Bytes left to be read: " + file.available());

            // 4. this method skips the 'n' bytes and then read afterwards. According to
            // industry standard, always calculate first then handle its result.

            long skippedElement = file.skip(2);
            System.out.println("Number of bytes skipped: " + skippedElement);

            // 5. reading file with the help of byte array, this method is more
            // efficient than reading one byte at a time.

            System.out.print("File content is as follow using the Array: ");

            byte[] byteArray = new byte[3];
            file.read(byteArray);
            for (int i = 0; i < byteArray.length; i++) {
                System.out.print((char) byteArray[i]);
            }
            System.out.println();

            // 6. A highly controlled version of bucket method that uses offset and length
            // of how many elements to add in the bucket manually.

            System.out.print("File content is as follow using the advance bucket method: ");

            byte[] b = new byte[7];
            file.read(b, 2, 5);

            for (int i = 0; i < b.length; i++) {
                System.out.print((char) b[i]);
            }
            System.out.println();

            // 7. to show the remaining file content

            System.out.print("File content is as follow: ");

            int dataByte = 0;

            while ((dataByte = file.read()) != -1) {
                System.out.print((char) dataByte);
            }
            System.out.println();

            // 8. as i am using try with resources so i dont need to use close() method.
            // beacuse try with resources do them by themselves.

        } catch (FileNotFoundException e) {
            System.out.println("The file is not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error happened while reading the file");
            // getMessage() returns a short error message in String, tells what went wrong
            // and is Simple and human-readable
            System.out.println(e.getMessage());
        }
    }
}