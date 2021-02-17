package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
