package countsort;

public class SortStudent {
    // method to find and return the sorted age of student
    public static int[] countSortAge(int[] studentAge) {

        // output array
        int[] output = new int[studentAge.length];

        // age difference to get the size of count array
        int ageDifference = 18 - 10 + 1;

        // count array to store the frequency
        int[] count = new int[ageDifference];

        // offset to get the correct index
        int offset = 10;

        // looping through studentAge
        for (int j : studentAge) {
            int idx = j - offset;
            count[idx]++;
        }

        // to maintain output array index
        int outputIdx = 0;

        // looping through the count array
        for (int i = 0; i < ageDifference; i++) {
            while(count[i] > 0) {
                output[outputIdx++] = i + offset;
                count[i]--;
            }
        }

        // returning the sorted ages
        return output;
    }
}
