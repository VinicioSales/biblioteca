package com.example;

import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        biblioteca.cadastrarLivro("3", "Titulo2", "Autor2");
        biblioteca.emprestarLivro("3");


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
        biblioteca.buscaLivro("4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscaLivro_deve_retornar_IllegalArgumentException_quando_id_vazio() throws LivroNaoEncontradoException {
        biblioteca.buscaLivro("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void buscaLivro_deve_retornar_IllegalArgumentException_quando_parametro_null() throws LivroNaoEncontradoException {
        biblioteca.buscaLivro(null);
    }

    @Test
    public void listarLivros_deve_retornar_lista_de_strings_caso_biblioteca_nao_vazia() throws BibliotecaVaziaException, LivroJaCadastradoException, BibliotecaCheiaException {
        List<String> livrosDisponiveis = biblioteca.listarLivros();
        assertTrue(!livrosDisponiveis.isEmpty());
    }

    @Test(expected = BibliotecaVaziaException.class)
    public void listarLivros_deve_retornar_BibliotecaVaziaException_caso_biblioteca_vazia() throws BibliotecaVaziaException {
        Biblioteca bibliotecaVazia = new Biblioteca(3);
        bibliotecaVazia.listarLivros();
    }

    @Test
    public void emprestarLivro_deve_retornar_true_caso_livro_disponivel() throws LivroNaoDisponivelException, LivroNaoEncontradoException{
        biblioteca.emprestarLivro("2");
        assertTrue(biblioteca.buscaLivro("2").getEmprestado());
    }

    @Test(expected = IllegalArgumentException.class)
    public void emprestarLivro_deve_lancar_IllegalArgumentException_caso_id_vazio() throws LivroNaoDisponivelException, LivroNaoEncontradoException{
        biblioteca.emprestarLivro("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void emprestarLivro_deve_lancar_IllegalArgumentException_caso_id_null() throws LivroNaoDisponivelException, LivroNaoEncontradoException{
        biblioteca.emprestarLivro(null);
    }

    @Test(expected = LivroNaoDisponivelException.class)
    public void emprestarLivro_deve_lancar_LivroNaoDisponivelException_caso_livro_nao_disponivel() throws LivroNaoDisponivelException, LivroNaoEncontradoException{
        biblioteca.emprestarLivro("2");
        biblioteca.emprestarLivro("2");
    }
    
    @Test
    public void devolverLivro_deve_retornar_true_caso_livro_devolvido() throws LivroNaoDisponivelException, LivroNaoEncontradoException{
        biblioteca.devolverLivro("3");
        assertFalse(biblioteca.buscaLivro("3").getEmprestado());
    }

    @Test(expected = IllegalArgumentException.class)
    public void devolverLivro_deve_lancar_IllegalArgumentException_caso_id_vazio() throws LivroNaoDisponivelException, LivroNaoEncontradoException{
        biblioteca.devolverLivro("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void devolverLivro_deve_lancar_IllegalArgumentException_caso_id_null() throws LivroNaoDisponivelException, LivroNaoEncontradoException{
        biblioteca.devolverLivro(null);
    }

    @Test(expected = LivroNaoDisponivelException.class)
    public void devolverLivro_deve_lancar_LivroNaoDisponivelException_caso_livro_nao_disponivel() throws LivroNaoDisponivelException, LivroNaoEncontradoException{
        biblioteca.emprestarLivro("2");
        biblioteca.emprestarLivro("2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void verificarDisponibilidade_deve_retornar_IllegalArgumentException_caso_id_nulo() {
        biblioteca.verificarDisponibilidade(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verificarDisponibilidade_deve_retornar_IllegalArgumentException_caso_id_vazio() {
        biblioteca.verificarDisponibilidade("");
    }

    @Test
    public void verificarDisponibilidade_deve_retornar_true_caso_livro_disponivel() {
        biblioteca.verificarDisponibilidade("2");
        assertTrue(biblioteca.verificarDisponibilidade("2"));
    }

}