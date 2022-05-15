package com.netcracker.domain.repository;

import com.netcracker.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
