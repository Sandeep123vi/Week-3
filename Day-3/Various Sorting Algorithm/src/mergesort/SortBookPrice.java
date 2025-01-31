package mergesort;

import java.util.ArrayList;

public class SortBookPrice {

    // method to sort and merge the two sorted arrays
    private static void merge(int[] arr, int st, int ed, int mid) {
        // temp array to store the sorted values
        ArrayList<Integer> temp = new ArrayList<>();

        // idx is start index of the first array
        int idx = st;

        // jdx is start index of the second array
        int jdx = mid + 1;

        // comparing both idx and jdx array storing the minimum in temp array
        while(idx <= mid && jdx <= ed) {
            if (arr[idx] > arr[jdx]) {
                temp.add(arr[jdx]);
                jdx++;
            }
            else {
                temp.add(arr[idx]);
                idx++;
            }
        }
        // if first array has some elements left
        while (idx <= mid) {
            temp.add(arr[idx]);
            idx++;
        }

        // if second array has some value left
        while (jdx <= ed) {
            temp.add(arr[jdx]);
            jdx++;
        }
        // tdx index counter for temp array
        int tdx = 0;
        for(int i = st; i < temp.size(); i++) {
            arr[i] = temp.get(tdx++);
        }
    }

    public static void mergeSort(int[] arr, int st, int ed) {
        // base case
        if(st >= ed) {
            return;
        }

        // calculating mid. mid will be used to split the array into 2 parts
        int mid = st + (ed - st) / 2;

        // splitting the array into two parts (if possible)
        mergeSort(arr, st, mid);
        mergeSort(arr, mid + 1, ed);

        // merging the two sorted array
        merge(arr, st, ed, mid);
    }
}
