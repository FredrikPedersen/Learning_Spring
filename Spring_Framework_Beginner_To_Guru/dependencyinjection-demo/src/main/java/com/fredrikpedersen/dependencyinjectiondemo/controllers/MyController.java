package com.fredrikpedersen.dependencyinjectiondemo.controllers;

import org.springframework.stereotype.Controller;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 11:26
 */

@Controller
public class MyController {

    public void hello() {
        System.out.println("Hello There");
    }
}
