package com.d2y.d2yreddit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2y.d2yreddit.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
