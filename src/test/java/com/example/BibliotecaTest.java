package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Livro livro;


    @Before
    public void setUp() throws Exception {
        biblioteca = new Biblioteca(3);
        biblioteca.cadastrarLivro("2", "Titulo2", "Autor2");
        livro = new Livro("2", "Titulo2", "Autor2");

    }

    @Test
    public void cadastrarLivroTest() throws Exception {
        biblioteca.cadastrarLivro("1", "Título1", "Autor1");
        assertEquals("1", biblioteca.buscaLivro("1").getId());
    }

    @Test
    public void buscaLivro_deve_retornar_livro_quando_livro_cadastrado() throws LivroNaoEncontradoException {
        Livro livroEncontrato = biblioteca.buscaLivro("2");
        assertTrue(livroEncontrato instanceof Livro);
    }

    @Test(expected = LivroNaoEncontradoException.class)
    public void buscaLivro_deve_retornar_LivroNaoEncontradoException_quando_livro_nao_cadastrado() throws LivroNaoEncontradoException {
        biblioteca.buscaLivro("3");
    }
}