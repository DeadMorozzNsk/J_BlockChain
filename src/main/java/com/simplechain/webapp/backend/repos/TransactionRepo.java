package com.simplechain.webapp.backend.repos;

import com.simplechain.webapp.backend.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, String> {
}
