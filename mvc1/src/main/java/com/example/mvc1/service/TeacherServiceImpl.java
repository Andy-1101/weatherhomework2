package com.example.mvc1.service;

import com.example.mvc1.domin.DTO.TeacherResponseDTO;
import com.example.mvc1.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Collection<TeacherResponseDTO> getAllTeacher() {
        Collection<TeacherResponseDTO> res = teacherRepository
                .getAllTeacher()
                .stream()
                .map(TeacherResponseDTO::new)
                .collect(Collectors.toList());

        return res;
    }





}
