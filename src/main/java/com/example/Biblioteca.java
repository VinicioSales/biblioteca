package com.example;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Biblioteca {

    private Livro[] biblioteca;

    public Biblioteca(int tamanhoBiblioteca) {
        this.biblioteca = new Livro[tamanhoBiblioteca];
    }

    /**
     * Cadastra um livro na biblioteca
     * 
     * @param id     o ID do livro
     * @param titulo o Titulo do livro
     * @param autor  o Autor do livro

    * @throws LivroJaCadastradoException se um livro com o mesmo ID já estiver cadastrado
    * @throws BibliotecaCheiaException   se a biblioteca estiver cheia e não puder acomodar mais livros

    */
    public void cadastrarLivro(String id, String titulo, String autor) throws LivroJaCadastradoException, BibliotecaCheiaException {
        
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i] == null) {
                Livro livro = new Livro(id, titulo, autor);
                biblioteca[i] = livro;
                return;
            } else if (biblioteca[i].getId().equals(id)) {
                throw new LivroJaCadastradoException("Livro Já cadastrado com o ID" + id);
            }
        }
        throw new BibliotecaCheiaException("Biblioteca cheia!");
    }

    /**
     * Busca um livro na biblioteca
     * 
     * @param id     o ID do livro

    * @throws LivroNaoEncontradoException se um livro não for encontrado

    */
    public Livro buscaLivro(String id) throws LivroNaoEncontradoException {
        if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Id de livro inválido:" + id);
            }
        for (int i = 0; i < biblioteca.length; i++) { 
            if (biblioteca[i] != null && biblioteca[i].getId().equals(id)) {
                return biblioteca[i];
            }
        }
        throw new LivroNaoEncontradoException("Livro com ID " + id + " Não encontrado");
    }

    public List<String> listarLivros() throws BibliotecaVaziaException {
        if (biblioteca[0] == null) {
            throw new BibliotecaVaziaException("Nenhum livro na cadastrado!");
        }
        List<String> livrosDisponiveis = new ArrayList<>();
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i] != null && !biblioteca[i].getEmprestado()) {
                livrosDisponiveis.add(biblioteca[i].getTitulo());
            }
        }
        return livrosDisponiveis;
    }

    public void emprestarLivro(String id) throws LivroNaoDisponivelException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do livro não pode ser nulo ou vazio");
        }
        for (Livro livro : biblioteca) {
            if (livro != null && livro.getId().equals(id) && !livro.getEmprestado()) {
                livro.setEmprestado(true);
                return;
            }
        }
        throw new LivroNaoDisponivelException("O livro com id " + id + " não está disponível");
    }

    public void devolverLivro(String id) throws LivroNaoDisponivelException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do livro não pode ser nulo ou vazio");
        }
        for (Livro livro : biblioteca) {
            if (livro != null && livro.getId().equals(id) && livro.getEmprestado()) {
                livro.setEmprestado(false);
                return;
            }
        }
        throw new LivroNaoDisponivelException("O livro com id " + id + " não está disponível");
    }

    public Boolean verificarDisponibilidade(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do livro não pode ser nulo ou vazio");
        }
        for (Livro livro : biblioteca) {
            if (livro.getId().equals(id) && !livro.getEmprestado()) {
                return true;
            }
        }
        return false;
    }
}