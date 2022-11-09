package com.example.FarmersApp.service;

import com.example.FarmersApp.Exceptions.UserNotFoundException;
import com.example.FarmersApp.model.Feeds;
import com.example.FarmersApp.repository.FeedsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedsService {
    @Autowired
    public FeedsRepository feedsRepository;

    public FeedsService(FeedsRepository feedsRepository) {
        this.feedsRepository = feedsRepository;
    }
    //retrieve  all feeds
    public List<Feeds> findAllFeeds(){
        return  feedsRepository.findAll();
    }
    //creating new feeds ratios
    public Feeds addFeeds(Feeds feeds){
        return feedsRepository.save(feeds);
    }

    //updating feeds details

    public Feeds updatingFeeds(Feeds feeds){
        return  feedsRepository.save(feeds);
    }
    //find feeds byId
    public Feeds findFeedsById(Long id){
        return  feedsRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("Feeds Id"+id+ "was not found"));
        }
        //delete record ById
    public void deleteFeed(Long id){
        feedsRepository.deleteFeedById(id);
    }
}
