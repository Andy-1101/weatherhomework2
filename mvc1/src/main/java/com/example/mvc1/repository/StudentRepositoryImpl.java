package com.example.mvc1.repository;

import com.example.mvc1.domin.entity.Student;
import com.example.mvc1.domin.entity.Teacher;
import com.example.mvc1.domin.entity.Teacher_Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collection;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private EntityManager conn;
    @Autowired
    public StudentRepositoryImpl(EntityManager conn) {
        this.conn = conn;
    }


    @Override
    public Student getStudentById(Integer student_id) {
        return conn.find(Student.class, student_id);
    }

    @Override
    public Collection<Student> getAllStudent() {
        return  conn.createQuery("FROM Student").getResultList();
    }

    @Override
    public synchronized Integer createStudent(Student student) {

        EntityTransaction tx = conn.getTransaction();
        tx.begin();
        conn.merge(student);
        tx.commit();
        return null;

    }

    @Override
    public synchronized Integer updateStudent(Integer student_id, String student_name) {
        //Student student;
        Student student = conn.find(Student.class, student_id);
        student.setStudent_name(student_name);
        EntityTransaction tx = conn.getTransaction();
        tx.begin();
        conn.merge(student);
        tx.commit();

        return null;
    }

    @Override
    public Collection<Teacher> getAllTeacherById(Integer student_id) {
        return conn.find(Student.class, student_id)
                .getTeacher_student()
                .stream()
                .map(Teacher_Student::getTeacher_id).collect(Collectors.toList());
    }


}
