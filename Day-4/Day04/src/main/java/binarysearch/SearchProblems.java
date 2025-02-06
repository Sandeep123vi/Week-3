package binarysearch;

import java.util.*;

public class SearchProblems {

    // Method to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Finding the first missing positive
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // Function to perform Binary Search for a target element
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Finding the first missing positive integer
        int missing = findFirstMissingPositive(arr.clone());
        System.out.println("First Missing Positive Integer: " + missing);

        Arrays.sort(arr);

        // Input the target number for binary search
        System.out.print("Enter the target number: ");
        int target = scanner.nextInt();

        // Performing Binary Search
        int index = binarySearch(arr, target);
        System.out.println("Target Index: " + index);

    }
}

