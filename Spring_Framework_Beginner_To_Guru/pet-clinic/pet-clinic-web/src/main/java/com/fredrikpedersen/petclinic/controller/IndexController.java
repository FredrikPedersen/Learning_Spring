package com.fredrikpedersen.petclinic.controller;

import com.fredrikpedersen.petclinic.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 18:22
 */

@Controller
public class IndexController {

    @RequestMapping({"/", "", "index", "index.html"})
    public String index() {
        return Constants.getIndexView();
    }

}
