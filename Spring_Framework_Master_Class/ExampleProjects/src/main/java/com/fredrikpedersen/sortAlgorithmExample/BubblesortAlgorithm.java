package com.fredrikpedersen.sortAlgorithmExample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubble")
public class BubblesortAlgorithm implements SortAlgorithm {

    //Dummy method for demonstration purposes
    public int[] sort(int[] numbers) {
        System.out.println("Bubble bubble");
        return numbers;
    }
}
