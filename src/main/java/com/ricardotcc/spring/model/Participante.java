package com.ricardotcc.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int codLogin;
    private String categoria;
    private Boolean responsavel;


    public Participante() 
    {

    }

    public Participante(Long id, int codLogin, String categoria, Boolean responsavel)
    {
        this.id = id;
        this.codLogin = codLogin;
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
    public int getCodUlogin() {
        return codLogin;
    }
    public void setCodUlogin(int codUlogin) {
        this.codLogin = codUlogin;
    }
    public void setId(Long id) {
        this.id = id;
    }    

}
