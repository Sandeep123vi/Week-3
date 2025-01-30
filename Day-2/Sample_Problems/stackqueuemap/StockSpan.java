package stackqueuemap;

import java.util.Stack;

public class StockSpan {


    // Function to calculate stock span values
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // Array to store span values
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        // Iterate through each stock price
        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and top element is less than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, it means no greater element is present on left, so span = i + 1
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Otherwise, span is difference between current index and top of stack
                span[i] = i - stack.peek();
            }

            // Push current index onto stack
            stack.push(i);
        }

        return span;
    }

    // Driver code
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85}; // Example stock prices
        int[] spans = calculateSpan(prices); // Compute spans

        // Print result
        System.out.print("Stock Span: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}


