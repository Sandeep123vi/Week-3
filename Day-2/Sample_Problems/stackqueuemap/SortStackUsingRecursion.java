package stackqueuemap;

import java.util.Stack;

class SortStackUsingRecursion{

        public static void sortStack(Stack<Integer> stack) {
            if (!stack.isEmpty()) {
                // Remove the top element
                int top = stack.pop();

                // Recursively sort the remaining stack
                sortStack(stack);

                // Insert the removed element at the correct position
                insertSorted(stack, top);
            }
        }

        private static void insertSorted(Stack<Integer> stack, int element) {
            if (stack.isEmpty() || stack.peek() <= element) {
                stack.push(element);
            } else {
                // Remove the top element and insert again
                int top = stack.pop();
                insertSorted(stack, element);
                stack.push(top);
            }
        }

        // Driver code
        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();
            stack.push(30);
            stack.push(-5);
            stack.push(18);
            stack.push(14);
            stack.push(-3);

            System.out.println("Original Stack: " + stack);
            sortStack(stack);
            System.out.println("Sorted Stack: " + stack);
        }
    }
