package com.courseSpringBoot.Student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Studen> getStudents(){
        return List.of(
                new Studen(
                        1L,
                        "maria paula",
                        "mari@gmail.com",
                        LocalDate.of(2002, Month.FEBRUARY,28),
                        17
                )
        );
    }
}
