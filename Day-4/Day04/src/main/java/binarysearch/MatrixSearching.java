package binarysearch;

public class MatrixSearching {

    // Function to search for a target in the matrix
    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;

        }

        // Define the number of rows and columns
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Initialize the binary search pointers (left and right)
        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            // Convert the mid index to row and column
            int midRow = mid / columns;
            int midCol = mid % columns;

            // Get the middle element
            int midElement = matrix[midRow][midCol];

            // If the middle element is the target, return true
            if (midElement == target) {
                return true;
            }

            if (midElement > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example 2D sorted matrix
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;

        // Search for the target in the matrix
        boolean result = searchMatrix(matrix, target);

        // Print the result
        System.out.println("Target " + target + " found: " + result);
    }
}
