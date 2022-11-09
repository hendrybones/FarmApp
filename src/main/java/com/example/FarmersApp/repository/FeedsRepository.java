package com.example.FarmersApp.repository;

import com.example.FarmersApp.model.Feeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedsRepository extends JpaRepository<Feeds, Long> {
    void deleteFeedById(Long id);
    Optional<Feeds> findById(Long id);
}
