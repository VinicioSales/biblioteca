package com.example;

public class LivroNaoDisponivelException extends Exception {
    public LivroNaoDisponivelException(String message) {
        super(message);
    }

    public LivroNaoDisponivelException(String message, Throwable causa) {
        super(message, causa);
    }
}
