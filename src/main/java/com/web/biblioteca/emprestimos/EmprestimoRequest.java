package com.web.biblioteca.emprestimos;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmprestimoRequest {

    private Long membro_id;
    private Long livro_id;
    @NotNull(message = "Data do empréstimo não pode estar nula")
    private LocalDate dataInicial;
    @NotNull(message = "Data limite para devolução não pode estar nula")
    private LocalDate dataParaDevolucao;
    @NotNull(message = "Data da devolução não pode estar nula")
    private LocalDate dataDevolucao;
    @NotNull(message = "Prazo para devolução em dias não pode ser nulo. ")
    private Integer prazoEmDias;
    @NotNull(message = "Valor para cobrança normal não pode ser nulo. ")
    private BigDecimal valorNormal;

    private BigDecimal valorMulta;
    private BigDecimal valorTotal;
    private String comentario;

    public Long getMembro_id() {
        return membro_id;
    }

    public void setMembro_id(Long membro_id) {
        this.membro_id = membro_id;
    }

    public Long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataParaDevolucao() {
        return dataParaDevolucao;
    }

    public void setDataParaDevolucao(LocalDate dataParaDevolucao) {
        this.dataParaDevolucao = dataParaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getPrazoEmDias() {
        return prazoEmDias;
    }

    public void setPrazoEmDias(Integer prazoEmDias) {
        this.prazoEmDias = prazoEmDias;
    }

    public BigDecimal getValorNormal() {
        return valorNormal;
    }

    public void setValorNormal(BigDecimal valorNormal) {
        this.valorNormal = valorNormal;
    }

    public BigDecimal getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(BigDecimal valorMulta) {
        this.valorMulta = valorMulta;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public EmprestimoRequest() {}
    public EmprestimoRequest(EmprestimoEntity emprestimoEntity) {
        this.dataInicial = emprestimoEntity.getDataInicial();
        this.dataParaDevolucao = emprestimoEntity.getDataParaDevolucao();
        this.dataDevolucao = emprestimoEntity.getDataDevolucao();
        this.prazoEmDias = emprestimoEntity.getPrazoEmDias();
        this.valorMulta = emprestimoEntity.getValorMulta();
        this.valorNormal = emprestimoEntity.getValorNormal();
        this.valorTotal = emprestimoEntity.getValorTotal();
        this.comentario = emprestimoEntity.getComentario();
    }
}
