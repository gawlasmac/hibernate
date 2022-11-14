package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(final StudentRepository repository) {
        return args -> {
            Student bob = new Student("Bob", "bob@mail.com", LocalDate.of(2000, Month.FEBRUARY, 2));
            Student alex = new Student("Alex", "alex@mail.com", LocalDate.of(2001, Month.OCTOBER, 13));
            repository.saveAll(List.of(bob, alex));
        };
    }
}
