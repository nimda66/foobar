package org.hintze.service;

public interface CheckoutService {

    void scan(String item);

    int total();
}
