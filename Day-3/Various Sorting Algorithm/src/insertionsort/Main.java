//Insertion Sort - Sort Employee IDs
//Problem Statement:
//A company stores employee IDs in an unsorted array. Implement Insertion Sort to sort the employee IDs in ascending order.
//        Hint:
//Divide the array into sorted and unsorted parts.
//Pick an element from the unsorted part and insert it into its correct position in the sorted part.
//Repeat for all elements.



package insertionsort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // example array of employee id
        int[] id = {81, 89, 9, 11, 14, 76, 54, 22};

        // printing the id array
        System.out.println(Arrays.toString(id));

        // sorting the id array
        SortEmployeeId.insertionSort(id);

        // printing the sorted id array
        System.out.println(Arrays.toString(id));
    }
}
