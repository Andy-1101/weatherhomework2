package com.example.mvc1.repository;

import com.example.mvc1.domin.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TeacherRepository {
    Collection<Teacher> getAllTeacher();

}
