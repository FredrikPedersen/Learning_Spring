package com.fredrikpedersen.SpringLevel1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgorithm implements SortAlgorithm{

    //Dummy method for demonstration purposes
    public int[] sort(int[] numbers) {
        return numbers;
    }
}
