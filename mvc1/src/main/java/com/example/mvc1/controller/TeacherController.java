package com.example.mvc1.controller;

import com.example.mvc1.exception.ResourceNotFoundException;
import com.example.mvc1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTeacher(){

        try {
            return new ResponseEntity<>(teacherService.getAllTeacher(), HttpStatus.OK);
        } catch (ResourceNotFoundException ex){
            String res = ex.toString();
            return new ResponseEntity<>(res,HttpStatus.NO_CONTENT);
        }


    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<?> handleException(){
        return new ResponseEntity<>("No Content!", HttpStatus.NO_CONTENT);
    }
}
