package com.web.biblioteca.livros;

import jakarta.persistence.*;

@Entity
@Table(name = "livrodb")
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private String anoLancamento;
    private String isbn;
    private Integer quantidade;

    public LivroEntity() {}
    public LivroEntity(LivroRequest request) {
        this.titulo = request.getTitulo();
        this.autor = request.getAutor();
        this.genero = request.getGenero();
        this.anoLancamento= request.getAnoLancamento();
        this.isbn = request.getIsbn();
        this.quantidade = request.getQuantidade();
    }
    public LivroEntity(LivroDto request) {
        this.titulo = request.getTitulo();
        this.autor = request.getAutor();
        this.genero = request.getGenero();
        this.anoLancamento= request.getAnoLancamento();
        this.isbn = request.getIsbn();
        this.quantidade = request.getQuantidade();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
