package com.fredrikpedersen.SpringLevel1;

public class BinarySearchImpl {

    private SortAlgorithm sortAlgorithm;

    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        super();
        this.sortAlgorithm = sortAlgorithm;
    }

    //Dummy method for demonstration purposes
    public int binarySearch(int[] numbers, int numberToSearchFor) {

        sortAlgorithm.sort(numbers);

        return 3;
    }
}
