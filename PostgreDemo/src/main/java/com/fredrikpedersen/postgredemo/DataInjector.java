package com.fredrikpedersen.postgredemo;

import com.fredrikpedersen.postgredemo.model.Person;
import com.fredrikpedersen.postgredemo.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequiredArgsConstructor
public class DataInjector implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        insertPerson();
    }

    public Person insertPerson() {
        return personRepository.save(new Person("Fredrik", "Roadway 123", "123456789"));
    }
}
