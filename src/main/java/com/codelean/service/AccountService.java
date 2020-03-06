package com.codelean.service;

import com.codelean.model.Account;
import com.codelean.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface AccountService {

    Iterable<Account> findAll();

    Optional<Account> findById(Long id);

    void save(Account account);

    void remove(Long id);
}
