package com.web.biblioteca.membros;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public class MembroRequest {
    @NotNull(message = "Nome não pode estar nulo")
    @NotBlank(message = "Nome não pode estar em branco")
    private String nomeCompleto;
    @NotNull(message = "Endereço não pode estar nulo")
    @NotBlank(message = "Endereço não pode estar em branco")
    private String endereco;
    private String nacionalidade;
    @NotNull(message = "Email não pode estar nulo")
    @NotBlank(message = "Email não pode estar em branco")
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private Boolean alugou;


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

    public MembroRequest() {}

    public MembroRequest(MembroEntity membro) {
        this.nomeCompleto = membro.getNomeCompleto();
        this.endereco = membro.getEndereco();
        this.nacionalidade = membro.getNacionalidade();
        this.dataNascimento = membro.getDataNascimento();
        this.telefone = membro.getTelefone();
        this.email = membro.getEmail();
        this.alugou = membro.getAlugou();
    }
}
