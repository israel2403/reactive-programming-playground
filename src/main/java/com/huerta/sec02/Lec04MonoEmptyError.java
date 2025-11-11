package com.huerta.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {

  private final static Logger log = LoggerFactory.getLogger(Lec04MonoEmptyError.class);

  public static void main(String[] args) {

    getUsername(3)
        .subscribe(s -> System.out.println(s),
            err -> log.error("error: {}", err.getMessage()));
  }

  public static Mono<String> getUsername(int userId) {
    return switch (userId) {
      case 1 -> Mono.just("John");
      case 2 -> Mono.empty();
      default -> Mono.error(() -> new RuntimeException("Invalid input"));
    };
  }
}
