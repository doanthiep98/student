package com.example.demo.controller;

import com.example.demo.model.Classes;
import com.example.demo.model.Student;
import com.example.demo.service.IClasses;
import com.example.demo.service.ISemester;
import com.example.demo.service.impl.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/class")
public class ClassController {

    @Autowired
    private ISemester iSemester;

    @Autowired
    private ClassService classService;

    @GetMapping
    public ResponseEntity<List<Classes>> findAll(){
        return new ResponseEntity<>(classService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create-class")
    public ResponseEntity<?> createClass(@RequestBody Classes classes) {
        return new ResponseEntity<>(classService.save(classes), HttpStatus.CREATED);
    }

    @PutMapping("/update-class")
    private ResponseEntity<?> updateClass(@RequestBody Classes classes) {
        Optional<Classes> optionalClasses = classService.findById(classes.getClassesId());
        if (optionalClasses.isPresent()) {
            return new ResponseEntity<>(classService.save(classes), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete-class/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable("id") Long id) {
        Optional<Classes> customerOptional = classService.findById(id);
        if (customerOptional.isPresent()) {
            classService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Classes> getClass(@PathVariable("id") Long id){
        Optional<Classes> classesOptional = classService.findById(id);
        if(classesOptional.isPresent()){
            return new ResponseEntity<>(classesOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
