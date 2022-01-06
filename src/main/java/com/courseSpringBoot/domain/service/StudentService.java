package com.courseSpringBoot.domain.service;

import com.courseSpringBoot.domain.repository.StudentRepository;
import com.courseSpringBoot.persistence.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {


    private StudentRepository studentRepository;
    
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()) {
            throw new IllegalStateException("email take");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if(!exist){
            throw new IllegalStateException("student with id "+studentId+" does not exits");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional//con esta anotacion no es necesario llamar al repository
    public void updateStudent(String name, String email,Long id) {
        boolean existStudent = studentRepository.existsById(id);
        if(!existStudent){
            throw new IllegalStateException("the student no exist");
        }

        Student student = studentRepository.getById(id);
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email take");
            }
            student.setEmail(email);
        }
    }
}
