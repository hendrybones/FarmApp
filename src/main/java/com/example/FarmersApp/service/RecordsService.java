package com.example.FarmersApp.service;

import com.example.FarmersApp.Exceptions.UserNotFoundException;
import com.example.FarmersApp.model.Records;
import com.example.FarmersApp.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordsService {
    @Autowired
    public RecordsRepository recordsRepository;
//    public RecordsService(RecordsRepository recordsRepository) {
//    }
    // creating a record
    public Records addRecords(Records records){
        return recordsRepository.save(records);
    }

    //retrieving all records
    public List<Records> findAllRecords(){
        return recordsRepository.findAll();
    }

    //retrieving products byId
    public Records findRecordsById(Long id){
        return recordsRepository.findRecordById(id)
                .orElseThrow(()->new UserNotFoundException("User by id" +id+"was not found"));
    }

    //updating details in the records
    public Records updateRecords(Records records){
        return recordsRepository.save(records);
    }

    // delete a details in the database
    public void deleteRecord(Long id){
        recordsRepository.deleteRecordById(id);
    }

}
