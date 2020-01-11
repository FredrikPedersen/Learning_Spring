package com.fredrikpedersen.SpringLevel1.SortAlgorithmExample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm{

    //Dummy method for demonstration purposes
    public int[] sort(int[] numbers) {
        System.out.println("I dream of fast");
        return numbers;
    }
}
