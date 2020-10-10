package com.mixer.webapp;

import com.mixer.mixerchain.entities.User;
import com.mixer.mixerchain.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserRepo userRepo;

    @PostMapping(path = "/users")
    public String addNewUser(@RequestParam(name = "name", required = true, defaultValue = "user1") String name,
                             @RequestParam(name = "email", required = false, defaultValue = "a@b.ru") String email,
                             @RequestParam(name = "address", required = true, defaultValue = "0x54asd6a4w8") String address,
                             @RequestParam(name = "password", required = true, defaultValue = "psw") String password,
                             Map<String, Object> model) {

        User newUser = new User(name, email, address, password);
        userRepo.save(newUser);
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "users";
    }

    @GetMapping("/users")
    public String showUsers(Map<String, Object> model) {
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "users";
    }

//    @GetMapping(path="/users")
//    public @ResponseBody Iterable<User> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return userRepo.findAll();
//    }
}

