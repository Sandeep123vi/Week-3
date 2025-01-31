//5. Selection Sort - Sort Exam Scores
//Problem Statement:
//A university needs to sort students’ exam scores in ascending order. Implement Selection Sort to achieve this.
//Hint:
//Find the minimum element in the array.
//Swap it with the first unsorted element.
//Repeat the process for the remaining elements.
//

package selectionsort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // example array of exam score
        int[] score = {81, 89, 9, 11, 14, 76, 54, 22};

        // printing the unsorted score
        System.out.println(Arrays.toString(score));

        // sorting the score
        SortExamScore.selectionSort(score);

        // printing the sorted score
        System.out.println(Arrays.toString(score));
    }
}
