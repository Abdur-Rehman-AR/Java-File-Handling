import java.io.*;

public class FileWriterExample {
    public static void main(String[] args) {
        
        // FileWriter class is used to write directly to a file.
        try(FileWriter fw = new FileWriter("File_1.txt", true);)
        {
            fw.write("This is file writer.");
            fw.write('A');
            
            System.out.println("Written to file successfully.");
        } 
        catch (IOException e) 
        {
            System.out.println("Error happened: " +e.getMessage());
        }
    }
}