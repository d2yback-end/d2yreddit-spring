package com.d2y.d2yreddit.models;

import java.util.Arrays;

import com.d2y.d2yreddit.exceptions.D2YRedditException;

public enum VoteType {
  UPVOTE(1), DOWNVOTE(-1),
  ;

  private int direction;

  VoteType(int direction) {
  }

  public static VoteType lookup(Integer direction) {
    return Arrays.stream(VoteType.values())
        .filter(value -> value.getDirection().equals(direction))
        .findAny()
        .orElseThrow(() -> new D2YRedditException("Vote not found!"));
  }

  public Integer getDirection() {
    return direction;
  }
}
