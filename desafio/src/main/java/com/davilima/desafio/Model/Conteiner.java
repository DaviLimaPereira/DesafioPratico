package com.davilima.desafio.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

@Entity
public class Conteiner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idConteiner;

    @Column(nullable = false)
    @Pattern(regexp = "[A-Z]{4}\\d{7}")
    private String nmConteiner;

    @Column(nullable = false, length = 2)
    private String tipo;

    @Column(nullable = false, length = 5)
    private String status;

    @Column(nullable = false, length = 10)
    private String categoria;

    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<Movimentacao> movimentacoes;


    public long getIdConteiner() {
        return this.idConteiner;
    }

    public void setIdConteiner(long idConteiner) {
        this.idConteiner = idConteiner;
    }

    public String getNmConteiner() {
        return this.nmConteiner;
    }

    public void setNmConteiner(String nmConteiner) {
        this.nmConteiner = nmConteiner;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Movimentacao> getMovimentacoes() {
        return this.movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

}
