package com.example.mvc2.service;

import com.example.mvc2.domain.WebEntry;
import com.example.mvc2.domain.WebEntryResponseDTO;
import com.example.mvc2.domain.WebEntryResponseDTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebEntryServiceImpl implements WebEntryService{
    private final RestTemplate restTemplate;
    @Value("${myURL}")
    private String myUrl;
    @Autowired
    public WebEntryServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<WebEntry> getAllEntries() {
        WebEntryResponseDTO data = restTemplate.getForObject(myUrl,WebEntryResponseDTO.class);
        return data.getEntries();
    }

    @Override
    public List<WebEntry> getAllEntries(String auth) {
        WebEntryResponseDTO data = restTemplate.getForObject(myUrl,WebEntryResponseDTO.class);
        return data.getEntries()
                .stream()
                .filter(e -> e.getAuth().equals(auth))
                .collect(Collectors.toList());
    }

    @Override
    public Integer returnTest(){
        return 1003;
    }


}
