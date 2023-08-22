package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LivroTest {
    

    Livro livro = new Livro("1", "Titulo", "Autor");

    @Test
    public void getIddeveRetornar1QuandoIdFor1() {
        assertEquals("1", livro.getId());
    }

    @Test
    public void getAutorDeveRetornarAutorQuandoAutorForAutor() {
        assertEquals("Autor", livro.getAutor());
    }

}
