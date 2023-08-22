package com.example;

public class BibliotecaVaziaException extends Exception {
    public BibliotecaVaziaException(String message) {
        super(message);
    }

    public BibliotecaVaziaException(String message, Throwable causa) {
        super(message, causa);
    }
}
