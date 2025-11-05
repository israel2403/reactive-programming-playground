package com.huerta.sec02;

import com.huerta.sec01.suscriber.SubscriberImpl;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
  public static void main(String[] args) {
    var mono = Mono.just("isra");
    var subscriber = new SubscriberImpl();

    mono.subscribe(subscriber);

    subscriber.getSubscription().request(10);
    subscriber.getSubscription().request(10);
    subscriber.getSubscription().cancel();
  }
}
