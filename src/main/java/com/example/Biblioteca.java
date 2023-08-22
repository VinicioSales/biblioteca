package com.example;
public class Biblioteca {

    private Livro[] biblioteca;

    public Biblioteca(int tamanhoBiblioteca) {
        this.biblioteca = new Livro[tamanhoBiblioteca];
    }

    public void cadastrarLivro(String id, String titulo, String autor) throws Exception {
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i] == null) {
                Livro livro = new Livro(id, titulo, autor);
                biblioteca[i] = livro;
                return;
            } else if (biblioteca[i].getId().equals(id)) {
                throw new Exception("Livro Já cadastrado com o ID" + id);
            }
        }
        throw new Exception("Biblioteca cheia!");
    }

    public Livro buscaLivro(String id) throws LivroNaoEncontradoException {
        for (int i = 0; i < biblioteca.length; i++) { 
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Id de livro inválido:" + id);
            }
            if (biblioteca[i] != null && biblioteca[i].getId().equals(id)) {
                return biblioteca[i];
            }
        }
        throw new LivroNaoEncontradoException("Livro com ID " + id + " Não encontrado");
    }
}