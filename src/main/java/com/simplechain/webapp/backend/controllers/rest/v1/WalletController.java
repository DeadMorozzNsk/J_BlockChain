package com.simplechain.webapp.backend.controllers.rest.v1;

import com.simplechain.webapp.backend.models.Wallet;
import com.simplechain.webapp.backend.models.WebUser;
import com.simplechain.webapp.backend.repos.WalletRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wallets")
public class WalletController {
    private final WalletRepo walletRepo;

    @Autowired
    public WalletController(WalletRepo walletRepo) {
        this.walletRepo = walletRepo;
    }

    @GetMapping
    public List<Wallet> getWallets() {
        return walletRepo.findAll();
    }

    @GetMapping("{id}")
    public Wallet getOne(@PathVariable("id") Wallet wallet) {
        return wallet;
    }

//    @PostMapping
//    public Wallet addWallet(@RequestBody WebUser user) {
//        Wallet wallet = new Wallet(user);
//        return walletRepo.save(wallet);
//    }

    @PutMapping("{id}")
    public Wallet update(@PathVariable("id") Wallet walletFromDb,
                        @RequestBody Wallet wallet) {
        BeanUtils.copyProperties(wallet, walletFromDb, "id");
        return walletRepo.save(walletFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteWallet(@PathVariable("id") Wallet wallet) {
        walletRepo.delete(wallet);
    }

}
