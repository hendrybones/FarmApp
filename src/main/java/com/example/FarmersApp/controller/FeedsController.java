package com.example.FarmersApp.controller;

import com.example.FarmersApp.model.Feeds;
import com.example.FarmersApp.service.FeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feeds")
public class FeedsController {
    @Autowired
    private final FeedsService feedsService;

    public FeedsController(FeedsService feedsService) {
        this.feedsService = feedsService;
    }

    //getting all records from the database
    @GetMapping("all")
    public ResponseEntity<List<Feeds>> getAllFeeds(){
        List<Feeds> feeds=feedsService.findAllFeeds();
        return new ResponseEntity<>(feeds, HttpStatus.OK);
    }

    //retrieving feeds by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Feeds> findFeedsById(@PathVariable("id")Long id){
        Feeds feeds=feedsService.findFeedsById(id);
        return new  ResponseEntity<>(feeds, HttpStatus.OK);
    }

    //creating new feeds
    @PostMapping("add")
    public ResponseEntity<Feeds> addFeeds(@RequestBody Feeds feeds){
        Feeds newFeeds=feedsService.addFeeds(feeds);
        return new  ResponseEntity<>(newFeeds,HttpStatus.CREATED);
    }

    //updating new feeds
    @PutMapping("update")
    public ResponseEntity<Feeds> updateFeeds(@RequestBody Feeds feeds){
        Feeds updateFeeds= feedsService.updatingFeeds(feeds);
        return  new ResponseEntity<>(updateFeeds, HttpStatus.OK);
    }

    //deleting new feeds
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteFeedsById(@PathVariable("id") Long id){
        feedsService.deleteFeed(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
