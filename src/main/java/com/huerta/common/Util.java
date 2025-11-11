package com.huerta.common;

import org.reactivestreams.Subscriber;

import com.github.javafaker.Faker;

public class Util {

  private static final Faker faker = Faker.instance();

  public static <T> Subscriber<T> subscriber() {
    return new DefaultSubscriber<>("");
  }

  public static <T> Subscriber<T> subscriber(final String name) {
    return new DefaultSubscriber<>(name);
  }

  public static Faker faker() {
    return faker;
  }
}
