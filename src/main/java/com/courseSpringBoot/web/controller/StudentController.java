package com.courseSpringBoot.web.controller;

import com.courseSpringBoot.domain.service.StudentService;
import com.courseSpringBoot.persistence.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @DeleteMapping("/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/putStudent/{studentId}")
    public void updateStudent(@RequestParam(required = false) String name,@RequestParam(required = false) String email,@PathVariable("studentId") Long id){
        studentService.updateStudent(name,email,id);
    }
}
