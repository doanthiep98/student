package com.example.demo.service.impl;

import com.example.demo.repository.TranscriptRepository;
import com.example.demo.model.Transcript;
import com.example.demo.service.ITranscript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TranscriptService implements ITranscript {
    @Autowired
    private TranscriptRepository transcriptRepository;
    @Override
    public Transcript save(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }

    @Override
    public void delete(Long id) {
        transcriptRepository.deleteById(id);
    }

    @Override
    public List<Transcript> getAll() {
        return transcriptRepository.findAll();
    }

    @Override
    public Transcript update(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }

    @Override
    public Optional<Transcript> findById(Long id) {
        return transcriptRepository.findById(id);
    }

    @Override
    public Optional<Transcript> findByName(String Name) {
        return Optional.empty();
    }

    @Override
    public List<Transcript> findAll() {
        return transcriptRepository.findAll();
    }

    @Override
    public List<Transcript> selectTranscriptBySubjectAndClass(Long classId, Long subjectId) {
        return new ArrayList<>() ;
    }
}
