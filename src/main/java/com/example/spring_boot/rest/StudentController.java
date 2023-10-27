package com.example.spring_boot.rest;

import com.example.spring_boot.dao.StudentDAO;
import com.example.spring_boot.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    // define endpoint for "/students" - return a list of students
    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("dannt", "nguyentien", "dandz123@gmail.com"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(StudentDAO studentDAO) {
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list ... keep it simple for now

        // check the studentId again list size

        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }
}
