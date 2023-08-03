package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student Vinisha = new Student(
                    "Vinisha",
                    "vinishav.ece2020@citchennai.net",
                    LocalDate.of(2003, 03, 22)
            );
            Student Alex = new Student(
                    "Alex",
                    "Alex.ece2020@citchennai.net",
                    LocalDate.of(1997, 8, 18)
            );
            studentRepository.saveAll(
                    List.of(Vinisha,Alex)
            );
        };

    }
}
