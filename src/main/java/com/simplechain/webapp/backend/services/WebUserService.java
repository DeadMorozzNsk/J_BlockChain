package com.simplechain.webapp.backend.services;

import com.simplechain.webapp.backend.repos.WalletRepo;
import com.simplechain.webapp.backend.repos.WebUserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class WebUserService {
    private WebUserRepo webUserRepo;
    private WalletRepo walletRepo;

    @Autowired
    public WebUserService(WebUserRepo webUserRepo, WalletRepo walletRepo) {
        this.webUserRepo = webUserRepo;
        this.walletRepo = walletRepo;
    }
}
