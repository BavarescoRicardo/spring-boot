package com.ricardotcc.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DetalheArtigo 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;    
    private String titulo;
    private String descricao;
    private byte[] fotoPublicacao;
    private Long codArtigo;


    public DetalheArtigo() {
    }


    public DetalheArtigo(Long codigo, String titulo, String descricao, byte[] fotoPublicacao, Long codArtigo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.fotoPublicacao = fotoPublicacao;
        this.codArtigo = codArtigo;
    }

    public Long getCodigo() {
        return codigo;
    }


    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public byte[] getfotoPublicacao() {
        return fotoPublicacao;
    }


    public void setfotoPublicacao(byte[] fotoPublicacao) {
        this.fotoPublicacao = fotoPublicacao;
    }


    public Long getCodArtigo() {
        return codArtigo;
    }


    public void setCodArtigo(Long codArtigo) {
        this.codArtigo = codArtigo;
    }
}
