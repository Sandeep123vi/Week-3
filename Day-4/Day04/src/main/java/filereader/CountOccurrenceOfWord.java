package filereader;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CountOccurrenceOfWord {

        public static void main(String[] args) {
            //  the file path
            String filePath = "src/main/java/filereader/Hello.txt";
            String targetWord = "is";
            /// Counter to track occurrences of the target word
            int wordCount = 0;

            try (FileReader fileReader = new FileReader(filePath);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    // Split the line into words using space or punctuation as delimiters
                    String[] words = line.split("\\s+|\\p{Punct}");

                    // Check each word and compare with the target word
                    for (String word : words) {
                        if (word.equalsIgnoreCase(targetWord)) {
                            wordCount++;
                        }
                    }
                }

                System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");

            } catch (IOException e) {
                // Handle exceptions if file is not found or any I/O error occurs
                System.out.println("Error:");
            }
        }}