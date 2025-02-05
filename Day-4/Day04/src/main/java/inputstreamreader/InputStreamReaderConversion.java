package inputstreamreader;

import java.io.*;

public class InputStreamReaderConversion {

     public static void main(String[] args) {

        String filePath = "src/main/java/filereader/Hello.txt";

        try (
                //Create a FileInputStream to read the binary data from the file
                FileInputStream fileInputStream = new FileInputStream(filePath);

                //FileInputStream in InputStreamReader to convert bytes to characters
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

                //  Use BufferedReader for efficient reading of character stream
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }

        catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error for reading the file: " + e.getMessage());
        }
    }
}
