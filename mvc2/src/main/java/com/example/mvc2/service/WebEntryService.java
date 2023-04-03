package com.example.mvc2.service;

import com.example.mvc2.domain.WebEntry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WebEntryService {

    List<WebEntry> getAllEntries();
    List<WebEntry> getAllEntries(String auth);

    Integer returnTest();
}
