package algorithmruntimeanalysis.comparingdifferentdatastructionforsearching;

import java.util.HashMap;
import java.util.HashSet;

public class HashSearch {
    public static boolean find(HashSet<Integer> dataSet, int target) {
        return dataSet.contains(target);
    }
}
