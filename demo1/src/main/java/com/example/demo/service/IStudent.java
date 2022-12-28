package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Transcript;

import java.util.List;

public interface IStudent extends  ICRUD<Student>{
    public List<Student> selectStudentFailed();
    double totalPoint(List<Transcript> transcriptList);
}
