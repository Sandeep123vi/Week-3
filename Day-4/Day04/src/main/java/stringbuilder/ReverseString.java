package stringbuilder;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        // Reverse the string using StringBuilder
        String reversedString = reverseString(input);
        System.out.println("Reversed string: " + reversedString);

    }

    // Method to reverse a string using StringBuilder
    public static String reverseString(String str)
    {
        // Create a StringBuilder object and append the input string
        StringBuilder sb = new StringBuilder(str);
        // Use the reverse() method to reverse the string
        sb.reverse();
        return sb.toString();
    }
}
