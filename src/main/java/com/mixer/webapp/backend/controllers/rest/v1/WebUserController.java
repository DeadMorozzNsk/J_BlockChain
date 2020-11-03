package com.mixer.webapp.backend.controllers.rest.v1;

import com.mixer.webapp.backend.models.WebUser;
import com.mixer.webapp.backend.repos.WebUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class WebUserController {
    private final WebUserRepo webUserRepo;

    @Autowired
    public WebUserController(WebUserRepo webUserRepo) {
        this.webUserRepo = webUserRepo;
    }

    @GetMapping
    public List<WebUser> getUsers() {
        return webUserRepo.findAll();
    }

    @GetMapping("{id}")
    public WebUser getOne(@PathVariable("id") WebUser webUser) {
        return webUser;
    }
}
