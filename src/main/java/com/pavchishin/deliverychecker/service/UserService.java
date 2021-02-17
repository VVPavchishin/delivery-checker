package com.pavchishin.deliverychecker.service;

import com.pavchishin.deliverychecker.model.User;
import com.pavchishin.deliverychecker.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepo.findByUsername(name);
    }

    public User findByUsername(String name) {
        return userRepo.findByUsername(name);
    }
    public void saveUser(User user) {
        userRepo.save(user);
    }
}
