package com.example.FarmersApp.repository;

import com.example.FarmersApp.model.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordsRepository  extends JpaRepository<Records, Long> {

    void deleteRecordById(Long id);
    Optional<Records> findRecordById(Long id);

    Optional<Records> findByName(String name);
}
