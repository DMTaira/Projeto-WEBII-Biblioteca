package com.web.biblioteca.emprestimos;


import com.web.biblioteca.livros.LivroEntity;
import com.web.biblioteca.membros.MembroEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "emprestimosdb")
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membro_id")
    private MembroEntity membro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id")
    private LivroEntity livro;
    private LocalDate dataInicial;
    private LocalDate dataParaDevolucao;
    private LocalDate dataDevolucao;
    private Integer prazoEmDias;
    private BigDecimal valorNormal;
    private BigDecimal valorMulta;
    private BigDecimal valorTotal;
    private String comentario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MembroEntity getMembro() {
        return membro;
    }

    public void setMembro(MembroEntity membro) {
        this.membro = membro;
    }

    public LivroEntity getLivro() {
        return livro;
    }

    public void setLivro(LivroEntity livro) {
        this.livro = livro;
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
}
