package com.example.search.controller;

import com.example.mvc1.domin.entity.Student;
import com.example.mvc2.controller.WebEntryController;
import com.example.mvc2.domain.WebEntry;
import com.example.mvc2.domain.WebEntryResponseDTO;
import com.example.mvc2.service.WebEntryService;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/weather/search/")
public class SearchController {
@Autowired
private RestTemplate restTemplate;

    private final String url1 = "http://localhost:9300/Student";
    private final String url2 = "http://localhost:9200/entry";
    ExecutorService threadPool = Executors.newFixedThreadPool(5);


    // test for Search
    @GetMapping
    @ApiOperation(value = "Test Api",
    notes = "This APi only return a string to test the connection",
    response = String.class)
    @HystrixCommand(fallbackMethod = "getFallbackTest") // if this method fail, call getFallbackTest()
    public ResponseEntity<?> getDetails() {
        CompletableFuture<ResponseEntity<?>> completableFuture = CompletableFuture.supplyAsync(() -> {
            return new ResponseEntity<>("This is search Test!", HttpStatus.OK);
        }, threadPool);
        //throw new RuntimeException();
        return completableFuture.join();
    }

    public ResponseEntity<?> getFallbackTest(){
        return new ResponseEntity<>("This is the Fallback Test!", HttpStatus.BAD_REQUEST);
    }


    //get all student
    @GetMapping("/Student")
    @HystrixCommand(fallbackMethod = "getStudentDetailsFallback")
    @ApiOperation(value="get all students",
    notes="This Api connect Student service to fetch Students' information",
    response=Collection.class)
    public Collection<Student> getStudentDetails() {
        CompletableFuture<Collection<Student>> completableFuture = CompletableFuture.supplyAsync(() -> {
            return restTemplate.getForObject(url1, Collection.class);
        }, threadPool);
        //throw new RuntimeException();
        return completableFuture.join();

    }

    public Collection<Student> getStudentDetailsFallback(){
        return null;
    }


    //get student by id
    @GetMapping("/Student/{student_id}")
    @ApiOperation(value="get the student by id",
            notes="This Api connect Student service to fetch Student's information by id",
            response=Student.class)
    @HystrixCommand(fallbackMethod = "noId")
    public ResponseEntity<?> getStudentDetailsById(@ApiParam("Enter student_id") @PathVariable Integer student_id) {

        CompletableFuture<ResponseEntity<?>> completableFuture = CompletableFuture.supplyAsync(() -> {
            return new ResponseEntity<>(restTemplate.getForObject(url1 + "/" +student_id, Student.class), HttpStatus.OK);
        }, threadPool);

        return completableFuture.join();

    }

    public ResponseEntity<?> noId(@ApiParam("Enter student_id") @PathVariable Integer student_id){
        return new ResponseEntity<>("Can't get student by id, Failed! Fallback!", HttpStatus.NOT_FOUND);
    }


    //get all entries
    @GetMapping("/entry")
    @ApiOperation(value="return all retries",
    notes="This Api connect to 3rd-party Api to fetch all entries",
    response=List.class)
    @HystrixCommand(fallbackMethod = "noEntries")
    public List<WebEntry> getWebEntriesDetails() {
        CompletableFuture<List<WebEntry>> completableFuture = CompletableFuture.supplyAsync(() -> {
            return restTemplate.getForObject(url2, List.class);
        }, threadPool);

        return completableFuture.join();

    }

    public List<WebEntry> noEntries() {
        return null;
    }

    //get entry by auth
    @GetMapping("/entry/{auth}")
    @ApiOperation(value="return all entries by auth",
            notes="This Api connect to 3rd-party Api to fetch all entries by auth",
            response=List.class)
    @HystrixCommand(fallbackMethod = "noAuth")
    public List<WebEntry> getWebEntriesDetailsByAuth(@PathVariable String auth) {
        CompletableFuture<List<WebEntry>> completableFuture = CompletableFuture.supplyAsync(() -> {
            return restTemplate.getForObject(url2+"?Auth=" + auth, List.class);
        }, threadPool);

        return completableFuture.join();

    }

    public List<WebEntry> noAuth(@PathVariable String auth) {
        return null;
    }


}
