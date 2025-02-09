package algorithmruntimeanalysis.comparingdifferentdatastructionforsearching;

import java.util.TreeSet;

public class BinarySearch {
    public static boolean find(TreeSet<Integer> dataSet, int target) {
        return dataSet.contains(target);
    }
}
