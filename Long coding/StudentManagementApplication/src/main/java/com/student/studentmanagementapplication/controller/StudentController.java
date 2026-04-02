package com.student.studentmanagementapplication.controller;

import com.student.studentmanagementapplication.model.Student;
import com.student.studentmanagementapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class
StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudent(@RequestBody Student s){
        return service.saveStudent(s);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student s){
        s.setId(id);
        return service.saveStudent(s);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
}