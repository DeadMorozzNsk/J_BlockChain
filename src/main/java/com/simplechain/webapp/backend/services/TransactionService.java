package com.simplechain.webapp.backend.services;

import com.simplechain.webapp.backend.models.Transaction;
import com.simplechain.webapp.backend.models.WebUser;
import com.simplechain.webapp.backend.repos.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepo transactionRepo;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public Transaction create(Transaction transaction, WebUser sender, WebUser receiver, double amount) {
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setAmount(amount);
        transactionRepo.save(transaction);
        return transaction;
    }
}
