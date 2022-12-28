package com.example.demo.controller;

import com.example.demo.model.Classes;
import com.example.demo.model.Student;
import com.example.demo.service.IStudent;
import com.example.demo.service.impl.ClassService;
import com.example.demo.service.impl.StudentService;
import com.example.demo.service.impl.SubjectService;
import com.example.demo.service.impl.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private IStudent iStudent;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create-student")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping("/update-student")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        Optional<Student> optionalStudent = studentService.findById(student.getId());
        if(optionalStudent.isPresent()){
            return new ResponseEntity<>(studentService.save(student),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable("id") Long id){
        Optional<Student> optionalStudent = studentService.findById(id);
        if(optionalStudent.isPresent()){
            studentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
        Optional<Student> studentOptional = iStudent.findById(id);
        if(studentOptional.isPresent()){
            return new ResponseEntity<>(studentOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
