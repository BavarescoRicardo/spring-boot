package com.ricardotcc.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long codLogin;
    private Long codArtigo;

    public Long getCodArtigo() {
        return codArtigo;
    }

    public void setCodArtigo(Long codArtigo) {
        this.codArtigo = codArtigo;
    }
    private String categoria;
    private Boolean responsavel;


    public Participante() 
    {

    }

    public Participante(Long id, Long codLogin, Long codArtigo, String categoria, Boolean responsavel)
    {
        this.id = id;
        this.codLogin = codLogin;
        this.codArtigo = codArtigo;
        this.categoria = categoria;
        this.responsavel = responsavel; 
    }

    public Long getId() {
        return id;
    }
    public boolean isResponsavel() {
        return responsavel;
    }
    public void setResponsavel(boolean responsavel) {
        this.responsavel = responsavel;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Long getCodUlogin() {
        return codLogin;
    }
    public void setCodUlogin(Long codUlogin) {
        this.codLogin = codUlogin;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
