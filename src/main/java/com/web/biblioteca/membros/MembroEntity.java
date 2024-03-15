package com.web.biblioteca.membros;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "membrosdb")
public class MembroEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nomeCompleto;
        private String endereco;
        private String nacionalidade;
        private String email;
        private String telefone;
        private LocalDate dataNascimento;
        private Boolean alugou;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getAlugou() {
        return alugou;
    }
    public void setAlugou(Boolean alugou) {
        this.alugou = alugou;
    }

    public MembroEntity() {}
    public MembroEntity(MembroRequest request) {
        this.nomeCompleto = request.getNomeCompleto();
        this.endereco = request.getEndereco();
        this.nacionalidade = request.getNacionalidade();
        this.dataNascimento = request.getDataNascimento();
        this.telefone = request.getTelefone();
        this.email = request.getEmail();
        this.alugou = request.getAlugou();
    }
    public MembroEntity(MembroDto request) {
        this.nomeCompleto = request.getNomeCompleto();
        this.endereco = request.getEndereco();
        this.nacionalidade = request.getNacionalidade();
        this.dataNascimento = request.getDataNascimento();
        this.telefone = request.getTelefone();
        this.email = request.getEmail();
        this.alugou = request.getAlugou();
    }
}
