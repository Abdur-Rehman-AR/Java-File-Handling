import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("File_1.txt");
            writer.write("My name is Abdur Rehman.");
            writer.close();
            System.out.println("File written Successfully.");
        } catch (IOException e) {
            System.out.println("An error Occurred.");
            e.printStackTrace();
        }
    }
}