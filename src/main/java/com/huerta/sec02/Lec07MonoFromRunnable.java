package com.huerta.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huerta.common.Util;

import reactor.core.publisher.Mono;

public class Lec07MonoFromRunnable {
  private static final Logger log = LoggerFactory.getLogger(Lec07MonoFromRunnable.class);

  public static void main(String[] args) {
    getProductName(2)
        .subscribe(Util.subscriber());
  }

  private static Mono<String> getProductName(int productId) {
    if (productId == 1) {
      return Mono.fromSupplier(() -> com.huerta.common.Util.faker().commerce().productName());
    }
    return Mono.fromRunnable(() -> notifyBusiness(productId));
  }

  private static void notifyBusiness(final int productId) {
    log.info("notify business on unavailability of the product {}", productId);
  }
}
