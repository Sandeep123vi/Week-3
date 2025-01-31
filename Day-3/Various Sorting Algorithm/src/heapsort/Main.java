//6. Heap Sort - Sort Job Applicants by Salary
//Problem Statement:
//A company receives job applications with different expected salary demands. Implement Heap Sort to sort these salary demands in ascending order.
//        Hint:
//Build a Max Heap from the array.
//Extract the largest element (root) and place it at the end.
//Re-heapify the remaining elements and repeat until sorted.


package heapsort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // example salary expected
        int[] salaryDemands = {8100, 8900, 900, 1100, 1400, 7600, 5400, 2200};

        // printing the unsorted array
        System.out.println(Arrays.toString(salaryDemands));

        // sorting the salary demands
        SortJobApplicationBySalary.maxHeap(salaryDemands);

        // printing the update salary demands array
        System.out.println(Arrays.toString(salaryDemands));
    }

}
