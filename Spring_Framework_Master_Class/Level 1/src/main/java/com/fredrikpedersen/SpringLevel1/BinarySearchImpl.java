package com.fredrikpedersen.SpringLevel1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    @Autowired
    //Most projects these days use setter injections without writing the actual setters or constructors
    private SortAlgorithm sortAlgorithm;

    //Dummy method for demonstration purposes
    public int binarySearch(int[] numbers, int numberToSearchFor) {

        sortAlgorithm.sort(numbers);

        return 3;
    }
}
