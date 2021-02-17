package com.pavchishin.deliverychecker.controllers;

import com.pavchishin.deliverychecker.model.Role;
import com.pavchishin.deliverychecker.model.User;
import com.pavchishin.deliverychecker.repository.PartTuRepository;
import com.pavchishin.deliverychecker.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class LoginController {

    private final UserService service;

    public LoginController(UserService service) {
        this.service = service;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {

        User userDb  = service.findByUsername(user.getUsername());
        if (userDb != null) {
            model.put("message", "User exist!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        service.saveUser(user);
        return "redirect:/login";
    }
}
