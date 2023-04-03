package com.example.mvc1.repository;

import com.example.mvc1.domin.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository{
    private EntityManager conn;

    @Autowired
    public TeacherRepositoryImpl(EntityManager conn) {
        this.conn = conn;
    }

    @Override
    public Collection<Teacher> getAllTeacher() {
        return conn.createQuery("FROM Teacher").getResultList();
    }

}
