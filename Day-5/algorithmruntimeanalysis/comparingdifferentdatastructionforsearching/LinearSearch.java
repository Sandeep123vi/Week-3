package algorithmruntimeanalysis.comparingdifferentdatastructionforsearching;

public class LinearSearch {
    public static boolean find(int[] dataSet, int target) {
        for (int j : dataSet) {
            if (j == target) {
                return true;
            }
        }
        return false;
    }
}
