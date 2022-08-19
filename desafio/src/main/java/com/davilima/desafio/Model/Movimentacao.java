package com.davilima.desafio.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

@Entity
public class Movimentacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMovimentacao;

    @Column(nullable = false, length = 10)
    private String nmMovimentacao;

    @Column(nullable = false)
    @Pattern(regexp = "dd/MM/YYYY HH:mm")
    private Date inicioMovimentacao;

    @Column(nullable = false)
    @Pattern(regexp = "dd/MM/YYYY HH:mm")
    private Date fimMovimentacao;

    @ManyToOne
    private Conteiner conteiner;


    public long getIdMovimentacao() {
        return this.idMovimentacao;
    }

    public void setIdMovimentacao(long idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public String getNmMovimentacao() {
        return this.nmMovimentacao;
    }

    public void setNmMovimentacao(String nmMovimentacao) {
        this.nmMovimentacao = nmMovimentacao;
    }

    public Date getInicioMovimentacao() {
        return this.inicioMovimentacao;
    }

    public void setInicioMovimentacao(Date inicioMovimentacao) {
        this.inicioMovimentacao = inicioMovimentacao;
    }

    public Date getFimMovimentacao() {
        return this.fimMovimentacao;
    }

    public void setFimMovimentacao(Date fimMovimentacao) {
        this.fimMovimentacao = fimMovimentacao;
    }

    public Conteiner getConteiner() {
        return this.conteiner;
    }

    public void setConteiner(Conteiner conteiner) {
        this.conteiner = conteiner;
    }

}
