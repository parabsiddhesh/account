package com.example.account.repository;

import org.springframework.stereotype.Repository;

import com.example.account.dto.Account;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface AccountRepository extends MongoRepository<Account, Integer>{

}
