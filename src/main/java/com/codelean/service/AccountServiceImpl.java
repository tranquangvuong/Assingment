package com.codelean.service;

import com.codelean.model.Account;
import com.codelean.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void save(Account account) {
    accountRepository.save(account);
    }

    @Override
    public void remove(Long id) {
    accountRepository.deleteById(id);
    }
}
