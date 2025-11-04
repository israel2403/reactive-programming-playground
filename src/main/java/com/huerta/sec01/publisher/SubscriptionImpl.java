package com.huerta.sec01.publisher;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

public class SubscriptionImpl implements Subscription {

  private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);

  private static final int MAX_ITEMS = 10;

  private final Faker faker;

  private final Subscriber<? super String> subscriber;

  private boolean isCancelled;

  private int count;

  public SubscriptionImpl(Subscriber<? super String> subscriber) {
    this.subscriber = subscriber;
    this.faker = Faker.instance();
  }

  @Override
  public void request(long reqeusted) {
    if (isCancelled) {
      return;
    }

    log.info("subscriber has requested {} items", reqeusted);

    if (reqeusted > MAX_ITEMS) {
      this.subscriber.onError(new RuntimeException("Validation failed"));
      this.isCancelled = true;
      return;
    }

    for (int i = 0; i < reqeusted && count < MAX_ITEMS; i++) {
      count++;
      this.subscriber.onNext(this.faker.internet().emailAddress());
    }
    if (count == MAX_ITEMS) {
      log.info(("no more data to produce"));
      this.subscriber.onComplete();
      this.isCancelled = true;
    }
  }

  @Override
  public void cancel() {
    log.info("subscriber has cancelled");
    this.isCancelled = true;
  }

}
