package org.example.paymentservice.exception;


public class UserBalanceException extends RuntimeException {
    public UserBalanceException(String message) {
        super(message);
    }
}
