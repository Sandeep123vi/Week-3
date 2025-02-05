package filereader;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReading {
    public static void main(String[] args) {
        // given the file path
        String filePath = "C:\\Users\\HP\\Desktop\\Day04\\src\\main\\java\\filereader\\Hello.txt";
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Print each line to the console
                System.out.println(line);
            }

        } catch (IOException e) {
            // Handle exceptions if file is not found or other I/O errors occur
            System.out.println(" May be error : " + e.getMessage());
        }
    }
}
