package heapsort;

public class SortJobApplicationBySalary {

    // function to swap parent with its node if needed to make max heap
    private static void heapify(int[] arr, int idx, int n) {
        // right child idx
        int leftIdx = 2 * idx + 1;

        // left child idx
        int rightIdx = 2 * idx + 2;

        // for both child not exist
        if (leftIdx >= n) {
            return;
        }

        // for one child (right child does not exist)
        if (rightIdx >= n) {
            if (arr[idx] < arr[leftIdx]) {
                // swapping left and parent
                arr[idx] = arr[idx] ^ arr[leftIdx];
                arr[leftIdx] = arr[idx] ^ arr[leftIdx];
                arr[idx] = arr[idx] ^ arr[leftIdx];
                heapify(arr, leftIdx, n);
            }
            // returning as the right child does not exist
            return;
        }
        // if both child exist and checking if left is the greatest
        if (arr[leftIdx] > arr[idx] && arr[leftIdx] > arr[rightIdx]) {
            // swapping left and parent
            arr[idx] = arr[idx] ^ arr[leftIdx];
            arr[leftIdx] = arr[idx] ^ arr[leftIdx];
            arr[idx] = arr[idx] ^ arr[leftIdx];
            heapify(arr, leftIdx, n);
        }

        // checking if the right is the biggest of all the three node
        if (arr[rightIdx] > arr[idx] && arr[rightIdx] > arr[leftIdx]) {
            // swapping right and parent
            arr[idx] = arr[idx] ^ arr[rightIdx];
            arr[rightIdx] = arr[idx] ^ arr[rightIdx];
            arr[idx] = arr[idx] ^ arr[rightIdx];
            heapify(arr, rightIdx, n);
        }
    }

    // takes heapify array sort it with the help of heapify functon
    private static void sortMaxHeap(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            // swap the last number with the root
            arr[i] = arr[i] ^ arr[0];
            arr[0] = arr[i] ^ arr[0];
            arr[i] = arr[i] ^ arr[0];
            // again making the root max
            heapify(arr, 0, i);
        }
    }
    // max heap implemented by arrays
    public static void maxHeap(int[] arr) {

        // from intermediate node to starting node or root we call heapify function to make a max heap of arr in place
        int intermediateNode = (arr.length - 2) / 2;
        for (int i = intermediateNode; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // sorting the max heap array
        sortMaxHeap(arr);
    }
}
