package com.example;

public class BibliotecaCheiaException extends Exception {
    public BibliotecaCheiaException(String message) {
        super(message);
    }

    public BibliotecaCheiaException(String message, Throwable causa) {
        super(message, causa);
    }
}
