package com.ricardotcc.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Artigo 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    public Artigo(String titulo, String descricao, byte[] imagem) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    private String titulo;
    private String descricao;
    private String observacao;
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    private byte[] imagem;
    private int codFlags;
    private int codTags;

    public Artigo()
    {

    }

    public int getCodTags() {
        return codTags;
    }

    public void setCodTags(int codTags) {
        this.codTags = codTags;
    }

    public int getCodFlags() {
        return codFlags;
    }

    public void setCodFlags(int codFlags) {
        this.codFlags = codFlags;
    }

    public Artigo(Long codigo, String titulo, String descricao, String observacao, int codFlags, int codTags, byte[] imagem)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.observacao = observacao;
        this.imagem = imagem;
        this.setCodFlags(codFlags);
        this.setCodTags(codFlags);
    }
    
    public Artigo(String titulo, String descricao)
    {
        this.titulo = titulo;
        this.descricao = descricao;
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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
