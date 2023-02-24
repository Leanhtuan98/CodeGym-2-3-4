package com.example.case_module_4.repository;

import com.example.case_module_4.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountRepo extends PagingAndSortingRepository<Account, Integer> {
    Account findAccountByUsername(String username);
}
