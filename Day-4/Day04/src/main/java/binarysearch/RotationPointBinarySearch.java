package binarysearch;

public class RotationPointBinarySearch {

    // Method to find the index of the smallest element
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int rotationIndex = findRotationPoint(arr);

        System.out.println("The rotation point (smallest element) is at index: " + rotationIndex);
        System.out.println("The smallest element is: " + arr[rotationIndex]);
    }
}
