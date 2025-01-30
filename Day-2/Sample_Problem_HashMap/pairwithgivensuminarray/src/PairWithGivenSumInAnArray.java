//Check for a Pair with Given Sum in an Array
//Problem: Given an array and a target sum, find if there exists a pair of elements whose sum is equal to the target.
//        Hint: Store visited numbers in a hash map and check if target - current_number exists in the map

import java.util.HashMap;

class FindGivenSumInArray {

    // boolean functon to check if pair exist
    public static boolean findTwoPair(int []nums, int n, int target) {
        HashMap<Integer , Integer> prev = new HashMap<>();

        // looping through array
        for (int i = 0; i < n; i++) {
            // checking if the other number is in hashmap or not
            if (prev.getOrDefault(target - nums[i], 0) != 0) {

                return true;
            }
            // pushing the ith val in hashmap
            prev.put(nums[i], i+1);

        }
        return false;
    }
}

public class PairWithGivenSumInAnArray {
    public static void main(String[] args) {
        //Problem: Given an array and a target sum, find if there exists a pair of elements whose sum is equal to the target.
        // example array
        int size = 10;
        int []nums = {1, 2, 3, 5, 8, 4, 1, 9, 6, 0};
        // getting the two index from functon
        boolean ans = FindGivenSumInArray.findTwoPair(nums, size, 0);
        if (ans) {
            System.out.println("Pair found");
        }
        else  {
            System.out.println("Pair not found");
        }
    }
}



