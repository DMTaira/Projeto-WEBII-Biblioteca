package com.web.biblioteca.livros;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;


public class LivroRequest {
    @NotNull(message = "Titulo não pode estar nulo")
    @NotBlank(message = "Titulo não pode estar em branco")
    private String titulo;
    @NotNull(message = "Autor não pode estar nulo")
    @NotBlank(message = "Autor não pode estar em branco")
    private String autor;
    @NotNull(message = "Genero não pode estar nulo")
    @NotBlank(message = "Genero não pode estar em branco")
    private String genero;
    @NotNull(message = "Ano de Lançamento não pode estar nulo")
    @NotBlank(message = "Ano de Lançamento não pode estar em branco")
    private String anoLancamento;
    @NotNull(message = "ISBN não pode estar nulo")
    @NotBlank(message = "ISBN não pode estar em branco")
    private String isbn;
    @NotNull(message = "Quantidade não pode estar nulo")
    @PositiveOrZero(message = "Quantidade deve ser maior ou igual a 0")
    private Integer quantidade;

    public LivroRequest() {}
    public LivroRequest (LivroEntity livroEntity) {
        this.titulo = livroEntity.getTitulo();
        this.autor = livroEntity.getAutor();
        this.genero = livroEntity.getGenero();
        this.anoLancamento= livroEntity.getAnoLancamento();
        this.isbn = livroEntity.getIsbn();
        this.quantidade = livroEntity.getQuantidade();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


}
