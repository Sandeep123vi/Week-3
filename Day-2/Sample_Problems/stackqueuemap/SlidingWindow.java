package stackqueuemap;
import java.util.*;
public class SlidingWindow{

    // Function to find the maximum element in each sliding window
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Array to store max elements of each window
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices of elements

        for (int i = 0; i < n; i++) {
            // Remove elements from the front if they are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back (they are useless)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element index at the back of the deque
            deque.offerLast(i);

            // Store the maximum for the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size and window size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the window size (k): ");
        int k = sc.nextInt();

        // Call function to find sliding window maximum
        int[] result = maxSlidingWindow(nums, k);

        // Print the result
        System.out.println("Maximum elements in each sliding window:");
        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
