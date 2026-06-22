import java.io.FileWriter;
import java.io.IOException;
public class WriteFile {
    public static void main(String[] args) {

        try {

            /*
             * FileWriter is a character stream class in Java designed to write text into a
             * file. It goes to your hard drive and finds the file whose name is given. If
             * the file already exists, it opens it up to overwrite it. If the file doesn't
             * exist, FileWriter is smart enough to automatically create the file for you!
             */
            FileWriter writer = new FileWriter("File_1.txt");

            /*
             * write() function takes your String and starts pushing it toward the file.
             * It doesn't instantly write to the hard drive because doing that
             * character-by-character is slow. Instead, it saves the text in a buffer.
             */
            writer.write("Hello World");

            /*
             * close() method Flushes the Data as it forces all the text stuck buffer
             * to instantly dump onto the physical hard drive. If you forget to call
             * close(), your file might end up completely empty. Also it Releases the
             * File as it unlocks the file so other applications on your computer can
             * open and read it.
             */
            writer.close();
            System.out.println("File written Successfully.");

            /*
             * IOException e catches any Input/Output errors that happen while your
             * program is talking to the hard drive.
             * When an error happens, printStackTrace() method prints a detailed
             * history report to console screen telling you exactly what went wrong,
             * why it went wrong, and the exact line number where the mistake happened.
             */

        } catch (IOException e) {
            System.out.println("An error Occurred.");
            e.printStackTrace();
        }
    }
}