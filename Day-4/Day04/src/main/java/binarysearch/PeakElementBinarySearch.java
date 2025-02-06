package binarysearch;

public class PeakElementBinarySearch {

    // Method to find a peak element index
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0}; // Example array
        int peakIndex = findPeakElement(arr);

        System.out.println("Peak element is at index: " + peakIndex);
        System.out.println("Peak element is: " + arr[peakIndex]);
    }
}
