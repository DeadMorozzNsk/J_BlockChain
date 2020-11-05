package com.simplechain.webapp.backend.controllers.rest.v1;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.simplechain.webapp.backend.models.Wallet;
import com.simplechain.webapp.backend.models.WebUser;
import com.simplechain.webapp.backend.repos.WalletRepo;
import com.simplechain.webapp.backend.repos.WebUserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class WebUserController {
    private final WebUserRepo webUserRepo;
    private final WalletRepo walletRepo;

    @Autowired
    public WebUserController(WebUserRepo webUserRepo, WalletRepo walletRepo) {
        this.webUserRepo = webUserRepo;
        this.walletRepo = walletRepo;
    }

    @GetMapping
    @JsonBackReference
    public List<WebUser> getUsers() {
        return webUserRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonBackReference
    public WebUser getOne(@PathVariable("id") WebUser webUser) {
        return webUser;
    }

    @PostMapping
    public WebUser addUser(@RequestBody WebUser webUser) {
        Wallet wallet = new Wallet(webUser);
        webUser.setWallet(wallet);
        walletRepo.save(wallet);
        return webUserRepo.save(webUser);
    }

    @PutMapping("{id}")
    public WebUser update(@PathVariable("id") WebUser userFromDb,
                        @RequestBody WebUser webUser) {
        BeanUtils.copyProperties(webUser, userFromDb, "id");
        return webUserRepo.save(userFromDb);
    }

    @DeleteMapping("delete")
    public void deleteUser(@RequestBody WebUser user) {
        WebUser webUser = webUserRepo.getOne(user.getId());
        webUserRepo.delete(webUser);
    }
}
