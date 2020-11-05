package com.simplechain.webapp.backend.repos;

import com.simplechain.webapp.backend.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Wallet, Long> {
}
