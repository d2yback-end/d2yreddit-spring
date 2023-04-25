package com.d2y.d2yreddit.exceptions;

public class D2YRedditException extends RuntimeException {
  public D2YRedditException(String exMessage, Exception exception) {
    super(exMessage, exception);
  }

  public D2YRedditException(String exMessage) {
    super(exMessage);
  }

}
