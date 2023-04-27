package com.d2y.d2yreddit.services;

import static com.d2y.d2yreddit.models.VoteType.UPVOTE;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.d2y.d2yreddit.dto.VoteDto;
import com.d2y.d2yreddit.exceptions.D2YRedditException;
import com.d2y.d2yreddit.exceptions.PostNotFoundException;
import com.d2y.d2yreddit.models.Post;
import com.d2y.d2yreddit.models.Vote;
import com.d2y.d2yreddit.repositories.PostRepository;
import com.d2y.d2yreddit.repositories.VoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final PostRepository postRepository;
    private final AuthService authService;

    @Transactional
    public void vote(VoteDto voteDto) {
        Post post = postRepository.findById(voteDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException("Post Not Found with ID - " + voteDto.getPostId()));
        Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post,
                authService.getCurrentUser());
        if (voteByPostAndUser.isPresent() &&
                voteByPostAndUser.get().getVoteType()
                        .equals(voteDto.getVoteType())) {
            throw new D2YRedditException("You have already "
                    + voteDto.getVoteType() + "'d for this post");
        }
        if (UPVOTE.equals(voteDto.getVoteType())) {
            post.setVoteCount(post.getVoteCount() + 1);
        } else {
            post.setVoteCount(post.getVoteCount() - 1);
        }
        voteRepository.save(mapToVote(voteDto, post));
        postRepository.save(post);
    }

    private Vote mapToVote(VoteDto voteDto, Post post) {
        return Vote.builder()
                .voteType(voteDto.getVoteType())
                .post(post)
                .user(authService.getCurrentUser())
                .build();
    }
}
