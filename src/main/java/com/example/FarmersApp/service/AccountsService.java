package com.example.FarmersApp.service;

import com.example.FarmersApp.model.Accounts;
import com.example.FarmersApp.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {
    @Autowired
    public AccountsRepository accountsRepository;

    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    //retrieve all records
    public List<Accounts> findAllAccountsDetails(){
        return accountsRepository.findAll();
    }

    //creating accounts details
    public Accounts addAccounts(Accounts accounts){
        return accountsRepository.save(accounts);
    }
    //updating accounts details
    public Accounts updatingAccountsDetails(Accounts accounts){
        return accountsRepository.save(accounts);
    }
    //deleting accounts details

    public  void deletingAccountsDetails(Long id){
        accountsRepository.deleteAccountsById(id);
    }
}
