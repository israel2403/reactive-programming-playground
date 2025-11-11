package com.huerta.sec02;

import com.huerta.common.Util;

import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {
  public static void main(String[] args) {
    getUsername(3)
        .subscribe(Util.subscriber());
  }

  public static Mono<String> getUsername(int userId) {
    return switch (userId) {
      case 1 -> Mono.just("John");
      case 2 -> Mono.empty();
      default -> Mono.error(() -> new RuntimeException("Invalid input"));
    };
  }
}
