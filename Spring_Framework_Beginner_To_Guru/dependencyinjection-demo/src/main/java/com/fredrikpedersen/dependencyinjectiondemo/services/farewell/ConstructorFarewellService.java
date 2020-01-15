package com.fredrikpedersen.dependencyinjectiondemo.services.farewell;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 13:08
 *
 * Note: Not part of the course, just me toying with @Qualifier
 */

@Service
@Qualifier("constructor")
public class ConstructorFarewellService implements FarewellService {

    @Override
    public String sayFarewell() {
        return "Goodbye, I was injected from a constructor";
    }
}
