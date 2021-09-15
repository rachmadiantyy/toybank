package com.example.toybank;


import com.example.toybank.repository.AccountTransaction;
import com.example.toybank.repository.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("transaction")
public class AccountTransactionController {

    private final TransactionRepository repository;

    public AccountTransactionController(TransactionRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<AccountTransaction> findTransaction(@PathVariable( "id") Integer id) {
        Optional<AccountTransaction> byId = repository.findById(id);
        return byId.isPresent() ? ResponseEntity.ok(byId.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public AccountTransaction createTransaction(@RequestBody AccountTransaction accountTransaction) {
        return repository.save(accountTransaction);
    }


}
