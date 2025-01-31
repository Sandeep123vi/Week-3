//4. Quick Sort - Sort Product Prices
//Problem Statement:
//An e-commerce company wants to display product prices in ascending order. Implement Quick Sort to sort the product prices.
//Hint:
//Pick a pivot element (first, last, or random).
//Partition the array such that elements smaller than the pivot are on the left and larger ones are on the right.
//Recursively apply Quick Sort on left and right partitions.


package quicksort;

import selectionsort.SortExamScore;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // example array
        int[] price = {81, 89, 9, 11, 14, 76, 54, 22, 32};

        // printing the unsorted the price array
        System.out.println(Arrays.toString(price));

        // sorting the price array with quick sort
        SortExamScore.selectionSort(price);

        // printing the sorted array
        System.out.println(Arrays.toString(price));
    }
}
