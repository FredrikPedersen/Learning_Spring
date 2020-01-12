package com.fredrikpedersen.sortAlgorithmExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //Use prototype to get different instances when creating more than one bean, use singleton to get only one instance
public class BinarySearchImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @PostConstruct //Called once the bean has been instantiated
    public void postConstruct() {
        logger.info("postConstruct: called");
    }

    @PreDestroy //Called right before the bean is destroyed
    public void preDestroy() {
        logger.info("preDestroy: called");
    }
}
