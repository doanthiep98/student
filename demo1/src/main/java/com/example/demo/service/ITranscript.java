package com.example.demo.service;

import com.example.demo.model.Transcript;

import java.util.List;

public interface ITranscript extends ICRUD<Transcript>{
  List<Transcript> selectTranscriptBySubjectAndClass(Long classId, Long subjectId);
}
