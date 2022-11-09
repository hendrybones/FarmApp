package com.example.FarmersApp.repository;

import com.example.FarmersApp.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    void deleteAccountsById(Long id);

    @Override
    Optional<Accounts> findById(Long id);
}
