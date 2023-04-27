package com.d2y.d2yreddit.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d2y.d2yreddit.dto.VoteDto;
import com.d2y.d2yreddit.services.VoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public ResponseEntity<Void> vote(@RequestBody VoteDto voteDto) {
        voteService.vote(voteDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
