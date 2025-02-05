package challengeproblem;

import java.io.*;
import java.util.StringTokenizer;

public class Challenge {

    // Method to measure the performance of StringBuilder
    public static void stringBuilderPerformance() {
        StringBuilder sb = new StringBuilder();
        long startTime = System.currentTimeMillis(); // Start time

        for (int i = 0; i < 1_000_000; i++) {
            sb.append("hello");
        }

        long endTime = System.currentTimeMillis(); // End time
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + " ms");
    }

    // Method to measure the performance of StringBuffer
    public static void stringBufferPerformance() {
        StringBuffer sb = new StringBuffer();
        long startTime = System.currentTimeMillis(); // Start time

        for (int i = 0; i < 1_000_000; i++) {
            sb.append("hello");
        }

        long endTime = System.currentTimeMillis(); // End time
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + " ms");
    }

    // Method to count words using FileReader
    public static void fileReaderPerformance(String filePath) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        } catch (IOException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("FileReader: Total words = " + wordCount + ", Time taken = " + (endTime - startTime) + " ms");
    }

    // Method to count words using InputStreamReader
    public static void inputStreamReaderPerformance(String filePath) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        } catch (IOException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("InputStreamReader: Total words = " + wordCount + ", Time taken = " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        // Compare StringBuilder and StringBuffer
        System.out.println("Comparing StringBuilder and StringBuffer:");
        stringBuilderPerformance();
        stringBufferPerformance();

        // Specify a large file path (ensure the file exists before running)
        String filePath = "src/main/java/challengeproblem/LargeFile.txt";  // Update this with the actual file path

        System.out.println("\nComparing FileReader and InputStreamReader:");
        fileReaderPerformance(filePath);
        inputStreamReaderPerformance(filePath);
    }
}
