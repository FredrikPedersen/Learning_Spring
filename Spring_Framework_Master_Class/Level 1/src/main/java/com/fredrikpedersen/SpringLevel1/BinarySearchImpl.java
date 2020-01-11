package com.fredrikpedersen.SpringLevel1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    @Autowired
    @Qualifier("bubble")
    //Most projects these days use setter injections without writing the actual setters or constructors
    //NOTE: Autowiring by name does not seem to function. Use @Primary og @Qualifier
    //@Primary vs @Qualifier: Primary is preferable when one dependency is the clear choice in all situations. Else, use Qualifier.
    private SortAlgorithm sortAlgorithm;

    //Dummy method for demonstration purposes
    public int binarySearch(int[] numbers, int numberToSearchFor) {

        sortAlgorithm.sort(numbers);

        return 3;
    }
}
