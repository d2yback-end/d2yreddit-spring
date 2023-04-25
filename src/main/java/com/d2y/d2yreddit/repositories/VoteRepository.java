package com.d2y.d2yreddit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2y.d2yreddit.models.Post;
import com.d2y.d2yreddit.models.User;
import com.d2y.d2yreddit.models.Vote;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
