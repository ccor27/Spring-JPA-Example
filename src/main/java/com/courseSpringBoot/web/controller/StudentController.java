package com.courseSpringBoot.web.controller;

import com.courseSpringBoot.domain.service.StudentService;
import com.courseSpringBoot.persistence.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
     return studentService.getStudents();
    }

    @PostMapping("/postStudent")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
}
