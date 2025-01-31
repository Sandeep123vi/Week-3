package bubblesort;

import static selectionsort.SortExamScore.swap;

public class SortStudentMark {
    // method to sort student mark by bubble sort
    public static void bubbleSort(int[] arr) {
        // size of array
        int n = arr.length;

        // optimization flag
        boolean swapped = false;
        // looping the array multiple times
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+ 1);
                    swapped = true;
                }
            }
            // if flag not trigger then everything already sorted
            if (!swapped){
                break;
            }
        }

    }
}
