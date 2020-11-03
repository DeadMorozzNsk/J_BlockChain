package com.simplechain.webapp.backend.controllers.rest.v1;

import com.simplechain.webapp.backend.models.Transaction;
import com.simplechain.webapp.backend.repos.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionRepo transactionRepo;

    @Autowired
    public TransactionController(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @RequestMapping
    public List<Transaction> getAll() {
        return transactionRepo.findAll();
    }

    @RequestMapping("{id}")
    public Transaction getOne(@PathVariable("id") Transaction transaction) {
        return transaction;
    }
}
