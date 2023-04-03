package com.example.mvc1.service;

import com.example.mvc1.domin.DTO.TeacherResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface TeacherService {
    Collection<TeacherResponseDTO> getAllTeacher();
}
