package quicksort;

import static selectionsort.SortExamScore.swap;

public class SortProductPrices {
    private static int partition(int[] arr, int st, int ed) {
        // starting position to swap from
        int i = st - 1;

        for (int j = st; j <= ed; j++) {
            // if pivot is smaller than j
            if (arr[j] < arr[ed]) {
                //increment i
                i++;
                swap(arr, i, j);
            }
        }
        // pivot will be swapped with i + 1
        swap(arr, i + 1, ed);
        // returning the pivot idx to main quickSort function
        return i + 1;
    }
    public static void quickSort(int[] arr, int st, int ed) {
        // base case
        if (st > ed){
            return;
        }

        // getting the pivot from partition function
        int pivot = partition(arr, st, ed);

        // with pivot, we can partition the array
        quickSort(arr, st, pivot - 1);
        quickSort(arr, pivot + 1, ed);
    }
}
