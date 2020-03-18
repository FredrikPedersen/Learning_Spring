package com.fredrikpedersen.petclinic.fauxspring;

import com.fredrikpedersen.petclinic.model.PetType;

import java.text.ParseException;
import java.util.Locale;


public interface Formatter<T> {

    String print(PetType petType, Locale locale);

    PetType parse(String text, Locale locale) throws ParseException;
}
