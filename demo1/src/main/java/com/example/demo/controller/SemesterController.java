package com.example.demo.controller;


import com.example.demo.model.Semester;
import com.example.demo.model.Transcript;
import com.example.demo.service.ISemester;
import com.example.demo.service.impl.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/semester")

public class SemesterController {
    @Autowired
    private SemesterService semesterService;

    @Autowired
    ISemester iSemester;

    @GetMapping
    public ResponseEntity<List<Semester>> findAll() {
        return new ResponseEntity<>(semesterService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create-semester")
    public ResponseEntity<?> createSemester(@RequestBody Semester semester) {
        return new ResponseEntity<>(semesterService.save(semester), HttpStatus.CREATED);
    }

    @PutMapping("/update-semester")
    public ResponseEntity<?> updateSemester(@RequestBody Semester semester) {
        Optional<Semester> semesterOptional = semesterService.findById(semester.getSemesterId());
        if(semesterOptional.isPresent()){
            return new ResponseEntity<>(semesterService.save(semester),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete-semester/{id}")
    public ResponseEntity<?> deleteSemester(@PathVariable("id") Long id){
        Optional<Semester> semesterOptional = semesterService.findById(id);
        if(semesterOptional.isPresent()){
            semesterService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Semester> getSemester(@PathVariable("id") Long id){
        Optional<Semester> semesterOptional = iSemester.findById(id);
        if(semesterOptional.isPresent()){
            return new ResponseEntity<>(semesterOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
