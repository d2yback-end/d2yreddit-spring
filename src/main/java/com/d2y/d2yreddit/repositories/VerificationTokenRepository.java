package com.d2y.d2yreddit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2y.d2yreddit.models.VerificationToken;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}
