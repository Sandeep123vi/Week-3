package insertionsort;

public class SortEmployeeId {

    // method to sort an array by insertion sort
    public static void insertionSort(int[] arr) {
        // size of array
        int n = arr.length;

        //  traversing the array
        for (int i = 1; i < n; i++) {
            // target integer that we want to add to sorted portion
            int target = arr[i];
            // one end of unsorted portion
            int j = i - 1;

            // this loop represent sorted array, and we are trying to insert target
            while (j >= 0 && arr[j] > target) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // putting the element to its place
            arr[j + 1] = target;
        }
    }
}
