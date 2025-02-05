package inputstreamreader;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // the file path
        String filePath = "src/main/java/inputstreamreader/empty.txt";

        try (
                // Create an InputStreamReader to read user input from System.in
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);

                // InputStreamReader with BufferedReader for efficient reading
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                // Create a FileWriter to write user input to a file
                FileWriter fileWriter = new FileWriter(filePath, true); // 'true' appends data to the file

                // FileWriter in BufferedWriter for efficient writing
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        )
        {
            System.out.println("Enter text to write in the file (type 'exit' to stop):");

            String userInput;

            while (!(userInput = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(userInput); // Write the input to file
                bufferedWriter.newLine(); // Move to the next line
            }

            System.out.println("User input has been added i file " + filePath);
        }

        catch (IOException e) {
            System.err.println("Error occurred: ");
        }
    }
}
