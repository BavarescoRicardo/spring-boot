package com.ricardotcc.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Usuario 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String nomeCompleto;
    private String bio;
    private String curso;
    private String descricao;
    private String observacao;
    private String grau;
    private byte[] fotoPerfil;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Login  login;

    public Usuario() {
    }

    public Usuario(Long codigo, String nomeCompleto, String bio, String curso, String descricao, String observacao,
            String grau, byte[] fotoPerfil, Login login) {
        this.codigo = codigo;
        this.nomeCompleto = nomeCompleto;
        this.bio = bio;
        this.curso = curso;
        this.descricao = descricao;
        this.observacao = observacao;
        this.grau = grau;
        this.fotoPerfil = fotoPerfil;
        this.login = login;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public String getGrau() {
        return grau;
    }
    public void setGrau(String grau) {
        this.grau = grau;
    }
    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }
    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    public Login getLogin() {
        return login;
    }
    public void setLogin(Login login) {
        this.login = login;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

}
