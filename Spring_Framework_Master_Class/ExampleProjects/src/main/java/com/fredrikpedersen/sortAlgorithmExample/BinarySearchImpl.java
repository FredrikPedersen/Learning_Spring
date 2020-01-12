package com.fredrikpedersen.sortAlgorithmExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //Use prototype to get different instances when creating more than one bean, use singleton to get only one instance
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
