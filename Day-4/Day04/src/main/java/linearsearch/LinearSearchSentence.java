package linearsearch;

import java.util.Scanner;

public class LinearSearchSentence {

    // Method to perform Linear Search
    public static String searchSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found"; // If no match is found, return "Not Found"
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number of sentences
        System.out.print("Enter the number of sentences: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] sentences = new String[n];

        System.out.println("Enter " + n + " sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }

        // Taking input for the word to search
        System.out.print("Enter the word to search: ");
        String word = scanner.nextLine();

        // Calling the method to search for the word
        String result = searchSentence(sentences, word);

        System.out.println("Result: " + result);

        scanner.close();
    }
}
