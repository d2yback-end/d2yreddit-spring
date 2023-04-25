package com.d2y.d2yreddit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2y.d2yreddit.models.Post;
import com.d2y.d2yreddit.models.SubReddit;
import com.d2y.d2yreddit.models.User;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(SubReddit subreddit);

    List<Post> findByUser(User user);
}
