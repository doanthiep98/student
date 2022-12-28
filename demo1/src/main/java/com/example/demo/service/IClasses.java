package com.example.demo.service;


import com.example.demo.model.Classes;
import com.example.demo.model.Student;

import java.util.List;

public interface IClasses extends ICRUD<Classes>{
    Classes findClassesByName(String className);
    List<Student> findAllStudentFromClass(String className);

}
