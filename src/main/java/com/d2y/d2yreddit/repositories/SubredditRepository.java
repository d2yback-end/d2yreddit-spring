package com.d2y.d2yreddit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2y.d2yreddit.models.SubReddit;

public interface SubredditRepository extends JpaRepository<SubReddit, Long> {
    Optional<SubReddit> findByName(String subredditName);
}
