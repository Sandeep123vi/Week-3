//Find All Subarrays with Zero Sum
//Problem: Given an array, find all subarrays whose elements sum up to zero.
//        Hint: Use a hash map to store the cumulative sum and its frequency. If a sum repeats, a zero-sum subarray exists.

import java.util.HashSet;

class SubArrayWithZeroSum{

    // function returns count
    public static int countSubArrays(int[] nums, int n) {
        int count = 0;
        // using hasSet insted off hash map as we only need one val to determine the sum
        HashSet<Integer> totalSum = new HashSet<>();

        // adding zero at the start
        totalSum.add(0);

        // cur sum var to denote the total sum upto Ith iteration
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            if (totalSum.contains(curSum)) {
                count++;
            }
            totalSum.add(curSum);
        }

        return count;
    }
}

public class FindSubArrayWithZeroSum {
    public static void main(String[] args) {
        // example
        int[] nums = {1, 4, -1, -4, -5, 9, 8, 2, -2};
        int size = 9;

        // printing the result
        System.out.println("the number of subarray with zero sum is : "+ SubArrayWithZeroSum.countSubArrays(nums, 9));

    }
}