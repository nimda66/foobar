package org.hintze.service;

/**
 * all operations for checkout
 */
public interface CheckoutService {

    void scan(String item);

    int total();
}
