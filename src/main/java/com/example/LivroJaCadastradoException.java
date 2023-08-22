package com.example;

public class LivroJaCadastradoException extends Exception {
    
    public LivroJaCadastradoException(String message) {
        super(message);
    }

    public LivroJaCadastradoException(String message, Throwable causa) {
        super(message, causa);
    }
}
