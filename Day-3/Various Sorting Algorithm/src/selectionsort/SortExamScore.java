package selectionsort;

public class SortExamScore {

    // swap function
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    // method to sort an array in ascending order by selection sort
    public static void selectionSort(int[] score) {

        // size of array store in n
        int n = score.length;

        // looping through the array
        for (int i = 0; i < n; i++) {

            // assuming the ith index have the smallest value
            int minNumberIdx = i;

            // searching in the rest of the array to find smaller value then current value
            for (int j = i + 1; j < n; j++) {

                // if smaller value exist then update the min number index to the current index (j is the currnet index)
                if (score[minNumberIdx] > score[j]) {
                    minNumberIdx = j;
                }
            }

            // checking if min number idx has been updated inside the loop
            if (minNumberIdx != i) {
                // swapping number
                swap(score, minNumberIdx, i);
            }
        }
    }
}
