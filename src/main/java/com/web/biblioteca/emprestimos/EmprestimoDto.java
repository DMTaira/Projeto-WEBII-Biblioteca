package com.web.biblioteca.emprestimos;

import java.math.BigDecimal;
import java.time.LocalDate;


public class EmprestimoDto {
    private Long membro_id;
    private Long livro_id;

    private LocalDate dataInicial;
    private LocalDate dataParaDevolucao;
    private LocalDate dataDevolucao;
    private Integer prazoEmDias;
    private BigDecimal valorMultaDiaria;
    private BigDecimal valorMulta;
    private String comentario;

    public EmprestimoDto(EmprestimoEntity emprestimoEntity) {
        this.livro_id = emprestimoEntity.getLivro().getId();
        this.membro_id = emprestimoEntity.getMembro().getId();
        this.dataInicial = emprestimoEntity.getDataInicial();
        this.dataParaDevolucao = emprestimoEntity.getDataParaDevolucao();
        this.dataDevolucao = emprestimoEntity.getDataDevolucao();
        this.prazoEmDias = emprestimoEntity.getPrazoEmDias();
        this.valorMulta = emprestimoEntity.getValorMulta();
        this.valorMultaDiaria = emprestimoEntity.getValorMultaDiaria();
        this.comentario = emprestimoEntity.getComentario();
    }

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

    public BigDecimal getMultaDiaria() {
        return valorMultaDiaria;
    }

    public void setMultaDiaria(BigDecimal multaDiaria) {
        this.valorMultaDiaria = multaDiaria;
    }

    public BigDecimal getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(BigDecimal valorMulta) {
        this.valorMulta = valorMulta;
    }


    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
