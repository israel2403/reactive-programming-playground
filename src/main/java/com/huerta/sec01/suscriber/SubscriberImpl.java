package com.huerta.sec01.suscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

@Getter
public class SubscriberImpl implements Subscriber<String> {

  private static final Logger log = LoggerFactory.getLogger(SubscriberImpl.class);

  private Subscription subscription;

  @Override
  public void onSubscribe(Subscription s) {
    this.subscription = s;
  }

  @Override
  public void onNext(String email) {
    log.info("receivied: {}", email);
  }

  @Override
  public void onError(Throwable t) {
    log.error("error", t);
  }

  @Override
  public void onComplete() {
    log.info("completed!");
  }
}
