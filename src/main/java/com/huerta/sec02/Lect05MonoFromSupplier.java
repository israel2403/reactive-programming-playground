package com.huerta.sec02;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huerta.common.Util;

import reactor.core.publisher.Mono;

public class Lect05MonoFromSupplier {
  private static final Logger log = LoggerFactory.getLogger(Lect06MonoFromCallable.class);

  public static void main(String[] args) {

    var list = List.of(1, 2, 3);
    Mono.fromSupplier(() -> sum(list))
        .subscribe(Util.subscriber());
  }

  public static int sum(final List<Integer> list) {
    log.info("finding the sum of {}", list);
    return list.stream().mapToInt(a -> a).sum();
  }
}
