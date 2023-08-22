package com.example;
public class Livro {
    private String id;
    private String titulo;
    private String autor;
    private Boolean emprestado;

    public Livro(
        String id,
        String titulo,
        String autor
    ) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        this.emprestado = emprestado;
    }

}