package com.example.demo.controller;

import com.example.demo.model.Classes;
import com.example.demo.model.Semester;
import com.example.demo.model.Transcript;
import com.example.demo.repository.TranscriptRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/transcript")
public class TranscriptController {
    @Autowired
    ITranscript transcriptService;
    @Autowired
    ISubject subjectService;
    @Autowired
    IStudent studentService;
    @Autowired
    IClasses iClasses;

    @Autowired
    ITranscript iTranscript;

    @Autowired
    TranscriptRepository transcriptRepository;

    @GetMapping
    public ResponseEntity<List<Transcript>> findAll() {
        return new ResponseEntity<>(transcriptService.getAll(), HttpStatus.OK);
    }

    @PostMapping("create-transcript")
    public ResponseEntity<?> creatTranscript(@RequestBody Transcript transcript) {
        return new ResponseEntity<>(transcriptService.save(transcript), HttpStatus.CREATED);
    }

    @PutMapping("update-transcript")
    public ResponseEntity<?> updateTranscript(@RequestBody Transcript transcript) {
        Optional<Transcript> transcriptOptional = transcriptService.findById(transcript.getTranscriptId());
        if (transcriptOptional.isPresent()) {
            return new ResponseEntity<>(transcriptService.save(transcript), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("delete-transcript/{id}")
    public ResponseEntity<?> deleteTranscript(@PathVariable("id") Long id){
        Optional<Transcript> transcriptOptional = transcriptService.findById(id);
        if(transcriptOptional.isPresent()){
            transcriptService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Transcript> getTranscript(@PathVariable("id") Long id){
        Optional<Transcript> transcriptOptional = iTranscript.findById(id);
        if(transcriptOptional.isPresent()){
            return new ResponseEntity<>(transcriptOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

