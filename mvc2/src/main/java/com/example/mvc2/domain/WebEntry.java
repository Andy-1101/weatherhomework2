package com.example.mvc2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebEntry {
    @JsonProperty("API")
    private String API;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("Auth")
    private String Auth;
    @JsonProperty("HTTPS")
    private boolean HTTPS;
    @JsonProperty("Cors")
    private String Cors;
    @JsonProperty("Link")
    private String Link;
    @JsonProperty("Category")
    private String Category;
    
    public String getAuth(){
        return Auth;
    }
}
