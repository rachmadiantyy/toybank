package com.example.toybank;


import com.example.toybank.repository.AccountTransaction;
import com.example.toybank.repository.TransactionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;

@Controller("transaction")
public class AccountTransactionController {

    private final TransactionRepository repository;

    public AccountTransactionController(TransactionRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/{id}")
    public AccountTransaction findTransaction(@PathParam( "id") int id) {
        return null ;
    }
    @PostMapping
    public AccountTransaction createTransaction(@RequestBody AccountTransaction accountTransaction) {
        return repository.save(accountTransaction) ;
    }


}
