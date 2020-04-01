package com.fredrikpedersen.postgredemo;

import com.fredrikpedersen.postgredemo.model.Person;
import com.fredrikpedersen.postgredemo.repository.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class PostgreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgreDemoApplication.class, args);
    }

    @Bean
    ApplicationRunner init(PersonRepository personRepository) {

        String[][] data = {
                {"Fredrik", "Oslo", "12345678"},
                {"Nikita", "Oslo", "87654321"},
                {"Cato", "Oslo", "12347658"},
                {"Victor", "Oslo", "99100162"}
        };

        return args -> {
            Stream.of(data).forEach(array -> {
                try {
                    Person person = new Person(
                            array[0],
                            array[1],
                            array[2]
                    );
                    personRepository.save(person);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            personRepository.findAll().forEach(System.out::println);
        };
    }

}
