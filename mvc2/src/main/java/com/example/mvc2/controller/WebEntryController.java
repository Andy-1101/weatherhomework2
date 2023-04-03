package com.example.mvc2.controller;

import com.example.mvc2.service.WebEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entry")
public class WebEntryController {

    private final WebEntryService webEntryService;

    @Autowired
    public WebEntryController(WebEntryService webEntryService) {
        this.webEntryService = webEntryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllEntries() {
        return new ResponseEntity<>(webEntryService.getAllEntries(), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<?> returnTest() {
        return new ResponseEntity<>("1005", HttpStatus.OK);
    }

    @GetMapping(params = {"auth"})
    public ResponseEntity<?> getAllEntries(@RequestParam String auth){
        return new ResponseEntity<>(webEntryService.getAllEntries(auth), HttpStatus.OK);
    }





}
