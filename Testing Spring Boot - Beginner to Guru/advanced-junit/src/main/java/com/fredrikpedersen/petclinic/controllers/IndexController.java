package com.fredrikpedersen.petclinic.controllers;

public class IndexController {

    public String index(){
        return "index";
    }

    public String oopsHandler() {
        throw new ValueNotFoundException();
    }
}
