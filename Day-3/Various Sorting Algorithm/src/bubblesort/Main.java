//1. Bubble Sort - Sort Student Marks
//Problem Statement:
//A school maintains student marks in an array. Implement Bubble Sort to sort the student marks in ascending order.
//        Hint:
//Traverse through the array multiple times.
//Compare adjacent elements and swap if needed.
//Repeat the process until no swaps are required.


package bubblesort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // example student marks array
        int[] marks = {81, 89, 9, 11, 14, 76, 54, 22};

        // printing the unsorted marks array
        System.out.println(Arrays.toString(marks));

        // sorting the marks array
        SortStudentMark.bubbleSort(marks);

        // printing the sorted marks array
        System.out.println(Arrays.toString(marks));
    }
}
