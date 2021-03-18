package com.pavchishin.deliverychecker.controllers;

import com.pavchishin.deliverychecker.model.Role;
import com.pavchishin.deliverychecker.model.User;
import com.pavchishin.deliverychecker.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/delivery/user")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", repository.findAll());
        return "user-list";
    }
    @GetMapping("/edit/{user}")
    public String userEdit(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";

    }

    @PostMapping("/edit")
    public String userSave(
            @RequestParam("userId") User user,
            @RequestParam Map<String, String> form,
            @RequestParam String username) {

        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        repository.save(user);
        return "redirect:/delivery/user";
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") User user) {
        repository.delete(user);
        return "redirect:/delivery/user";
    }
}
