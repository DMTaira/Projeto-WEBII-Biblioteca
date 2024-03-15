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
    private BigDecimal valorMultaDiaria;
    private BigDecimal valorMulta;
    private String comentario;

    public EmprestimoEntity () {}

    public EmprestimoEntity(EmprestimoRequest request,MembroEntity membro, LivroEntity livro) {
        this.membro = membro;
        this.livro = livro;
        this.dataInicial = request.getDataInicial();
        this.dataParaDevolucao = request.getDataParaDevolucao();
        this.dataDevolucao = request.getDataDevolucao();
        this.prazoEmDias = request.getPrazoEmDias();
        this.valorMultaDiaria = request.getValorMultaDiaria();
        this.valorMulta = request.getValorMulta();
        this.comentario = request.getComentario();
    }
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

    public BigDecimal getValorMultaDiaria() {
        return valorMultaDiaria;
    }

    public void setValorMultaDiaria(BigDecimal valorMultaDiaria) {
        this.valorMultaDiaria = valorMultaDiaria;
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
