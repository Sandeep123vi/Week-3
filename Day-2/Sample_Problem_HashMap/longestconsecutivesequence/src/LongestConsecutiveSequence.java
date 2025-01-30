//Longest Consecutive Sequence
//Problem: Given an unsorted array, find the length of the longest consecutive elements sequence.
//Hint: Use a hash map to store elements and check for consecutive elements efficiently.

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

class FindLongestSequence {
    public static int lengthOfSequence(int[] nums, int n) {
        // length of sequence
        int maxLength = 0;

        // hash map for integer key and boolean val
        HashMap<Integer, Boolean> numsMap = new HashMap<>();

        // finding the max number of the nums array
        int maxNum = 0;

        // loop on nums
        for (int i = 0; i < n; i++) {
            numsMap.put(nums[i], true);
            maxNum = max(maxNum, nums[i]);
        }

        // loop on hash map
        int i = 0;
        while(i <= maxNum) {
            if (numsMap.getOrDefault(i, false)) {
                int curLen = 1;
                i++;
                while(numsMap.getOrDefault(i, false) && i < maxNum) {
                    curLen ++;
                    numsMap.put(i, false);
                    i++;
                }
                maxLength = max(curLen, maxLength);
            }else {
                i++;
            }

        }

        return maxLength;
    }
}

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        // example array of unsorted numbers
        int[] nums = {1, 5, 3, 2, 3, 4, 8, 1, 2, 7, 8, 9, 10, 11, 12, 13, 14};
        int size = 17;
        System.out.println(FindLongestSequence.lengthOfSequence(nums, size));

    }
}