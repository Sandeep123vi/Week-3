//7. Counting Sort - Sort Student Ages
//Problem Statement:
//A school collects students’ ages (ranging from 10 to 18) and wants them sorted. Implement Counting Sort for this task.
//        Hint:
//Create a count array to store the frequency of each age.
//Compute cumulative frequencies to determine positions.
//Place elements in their correct positions in the output array.


package countsort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // taking an example array of student ages
        int[] age = {10, 18, 14, 12, 16, 15, 14, 14, 13, 12, 11, 11, 12};

        // the sorted age array contains the sorted list
        int[] sortedAge = SortStudent.countSortAge(age);

        // printing the sorted ages
        System.out.println(Arrays.toString(sortedAge));
    }
}
