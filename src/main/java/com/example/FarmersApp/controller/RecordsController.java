package com.example.FarmersApp.controller;

import com.example.FarmersApp.model.Records;
import com.example.FarmersApp.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "http://localhost:8080")
public class RecordsController {

    @Autowired
    private final RecordsService recordsService;

    public RecordsController(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

    //getting all records from the database
    @GetMapping("all")
    public ResponseEntity<List<Records>> getAllRecords(){
        List<Records>  records=recordsService.findAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    //retrieving feeds by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Records> findRecordsById(@PathVariable("id")Long id){
        Records records=recordsService.findRecordsById(id);
        return new  ResponseEntity<>(records, HttpStatus.OK);
    }

    //creating new feeds
    @PostMapping("add")
    public ResponseEntity<Records> addRecords(@RequestBody Records records){
        Records newRecords=recordsService.addRecords(records);
        return new  ResponseEntity<>(newRecords,HttpStatus.CREATED);
    }

    //updating new feeds
    @PutMapping("update")
    public ResponseEntity<Records> updateRecords(@RequestBody Records records){
        Records updateRecords= recordsService.updateRecords(records);
        return  new ResponseEntity<>(updateRecords, HttpStatus.OK);
    }

    //deleting new feeds
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteRecordsById(@PathVariable("id") Long id){
        recordsService.deleteRecord(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
