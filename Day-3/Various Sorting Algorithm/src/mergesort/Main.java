//3. Merge Sort - Sort an Array of Book Prices
//Problem Statement:
//A bookstore maintains a list of book prices in an array. Implement Merge Sort to sort the prices in ascending order.
//Hint:
//Divide the array into two halves recursively.
//Sort both halves individually.
//Merge the sorted halves by comparing elements.


package mergesort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // example book price array
        int[] price = {81, 89, 9, 11, 14, 76, 54, 22};

        // printing the unsorted price array
        System.out.println(Arrays.toString(price));

        // sorting the price array
        SortBookPrice.mergeSort(price, 0, price.length - 1);

        // printing the sorted price array
        System.out.println(Arrays.toString(price));
    }
}
