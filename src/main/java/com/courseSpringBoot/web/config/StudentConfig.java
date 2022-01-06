package com.courseSpringBoot.web.config;

import com.courseSpringBoot.domain.repository.StudentRepository;
import com.courseSpringBoot.persistence.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){

        return args -> {
            Student maria  =new Student(
                    "maria paula",
                    "mari@gmail.com",
                    LocalDate.of(2002, Month.FEBRUARY,28)
            );
            Student alex  =new Student(
                    "alex",
                    "alex@gmail.com",
                    LocalDate.of(2001, Month.FEBRUARY,2)
            );

            repository.saveAll(List.of(maria,alex));
        };
    }
}
