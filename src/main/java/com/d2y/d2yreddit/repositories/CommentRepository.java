package com.d2y.d2yreddit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2y.d2yreddit.models.Comment;
import com.d2y.d2yreddit.models.Post;
import com.d2y.d2yreddit.models.User;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
