package com.example.toybank.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface TransactionRepository extends CrudRepository<AccountTransaction, Integer> {
}
