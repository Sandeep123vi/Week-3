//Problem Statement: Comparing Different Data Structures for Searching
//Objective:
//Compare Array (O(N)), HashSet (O(1)), and TreeSet (O(log N)) for searching elements.
//Approach:
//Array: Linear search (O(N)).
//HashSet: Uses hashing (O(1) on average).
//TreeSet: Balanced BST (O(log N)).



package algorithmruntimeanalysis.comparingdifferentdatastructionforsearching;


import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static int[] generateDataSet(int size) {
        int[] dataSet = new int[size];
        Arrays.setAll(dataSet, i -> i);
        return dataSet;
    }
    public static void main(String[] args) {
        // example dataset size
        int dataSetSize = 10_00_000;

        // dataset of integers random generated from a method
        int[] dataSet = generateDataSet(dataSetSize);

        // now comparing arrays hasSet and treeSet time complexity

        int target = 748532;
        // linearSearch
        long startTime = System.nanoTime();
        System.out.println(LinearSearch.find(dataSet, target));
        long endTime = System.nanoTime();

        // time taken by arrays data structures
        System.out.println("Time taken by linear search arrays : "+ Math.abs(startTime - endTime));

        // binary search
        // creating a tree set object
        TreeSet<Integer> dataSetTree = new TreeSet<>();

        // copy the data from dataSet
        for (int i = 0; i < dataSetSize; i++) dataSetTree.add(dataSet[i]);

        startTime = System.nanoTime();
        System.out.println(BinarySearch.find(dataSetTree, target));
        endTime = System.nanoTime();

        System.out.println("Time taken by Binary search TreeSet : " + Math.abs(startTime - endTime));

        // hashing
        // creating a hash map
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < dataSetSize; i++) hashSet.add(dataSet[i]);
        startTime = System.nanoTime();
        System.out.println(HashSearch.find(hashSet, target));
        endTime = System.nanoTime();
        System.out.println("Time taken by hashing hashSet : " + Math.abs(startTime - endTime));
    }


}
