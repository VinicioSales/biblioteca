package com.example;

public class LivroNaoEncontradoException extends Exception {
    
    public LivroNaoEncontradoException(String message) {
        super(message);
    }

    public LivroNaoEncontradoException(String message, Throwable causa) {
        super(message, causa);
    }
}
