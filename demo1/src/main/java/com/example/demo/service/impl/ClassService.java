package com.example.demo.service.impl;

import com.example.demo.model.Classes;
import com.example.demo.repository.ClassRepository;
import com.example.demo.model.Student;
import com.example.demo.service.IClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements IClasses {
    @Autowired
    private ClassRepository classRepository;

    @Override
    public Classes save(Classes classes) {
        return classRepository.save(classes);
    }

    @Override
    public void delete(Long id) {
        classRepository.deleteById(id);
    }

    @Override
    public List<Classes> getAll() {
        return classRepository.findAll();
    }

    @Override
    public Classes update(Classes classes) {
        return classRepository.save(classes);
    }

    @Override
    public Optional<Classes> findById(Long idClass) {
        return classRepository.findById(idClass);
    }

    @Override
    public Optional<Classes> findByName(String Name) {
        return Optional.empty();
    }

    @Override
    public List<Classes> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Classes findClassesByName(String className) {
        Classes classes = new Classes();
        return classes;
    }

    @Override
    public List<Student> findAllStudentFromClass(String className) {
        List<Student> students = new ArrayList<>();
        return students;
    }
}
