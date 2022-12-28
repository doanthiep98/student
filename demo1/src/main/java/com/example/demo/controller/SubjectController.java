package com.example.demo.controller;

import com.example.demo.model.Subject;
import com.example.demo.service.ISubject;
import com.example.demo.service.impl.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/subject")

public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ISubject iSubject;

    @GetMapping
    public ResponseEntity<List<Subject>> findAll() {
        return new ResponseEntity<>(subjectService.getAll(), HttpStatus.OK);
    }

    @PostMapping("create-subject")
    public ResponseEntity<?> creatSubject(@RequestBody Subject subject) {
        return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
    }

    @PutMapping("update-subject")
    public ResponseEntity<?> updateSubject(@RequestBody Subject subject) {
        Optional<Subject> subjectOptional = subjectService.findById(subject.getSubjectId());
        if (subjectOptional.isPresent()) {
            return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("delete-subject/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable("id") Long id) {
        Optional<Subject> subjectOptional = subjectService.findById(id);
        if (subjectOptional.isPresent()) {
            subjectService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Subject> getSubject(@PathVariable("id")Long id){
        Optional<Subject> subjectOptional = iSubject.findById(id);
        if (subjectOptional.isPresent()){
            return new ResponseEntity<>(subjectOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
