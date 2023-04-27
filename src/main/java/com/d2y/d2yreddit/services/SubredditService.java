package com.d2y.d2yreddit.services;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.d2y.d2yreddit.dto.SubredditDto;
import com.d2y.d2yreddit.exceptions.D2YRedditException;
import com.d2y.d2yreddit.mapper.SubredditMapper;
import com.d2y.d2yreddit.models.SubReddit;
import com.d2y.d2yreddit.repositories.SubredditRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubredditService {

    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        SubReddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(toList());
    }

    public SubredditDto getSubreddit(Long id) {
        SubReddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new D2YRedditException("No subreddit found with ID - " + id));
        return subredditMapper.mapSubredditToDto(subreddit);
    }
}
