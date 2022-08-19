package com.davilima.desafio.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCliente;

    @Column(nullable = false)
    private String nmCliente;

    @OneToMany
    private List<Conteiner> conteiners;


    public long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNmCliente() {
        return this.nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public List<Conteiner> getConteiners() {
        return this.conteiners;
    }

    public void setConteiners(List<Conteiner> conteiners) {
        this.conteiners = conteiners;
    }

}
