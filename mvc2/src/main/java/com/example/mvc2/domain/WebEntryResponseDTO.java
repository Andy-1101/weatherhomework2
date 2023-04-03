package com.example.mvc2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebEntryResponseDTO {
    private int count;
    private List<WebEntry> entries;

    private WebEntry entry;

    public List<WebEntry> getEntries(){
        return entries;
    }

    public String getAuth(){
        return entry.getAuth();
    }

}
