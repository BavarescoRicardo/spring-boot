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
    private String titulo;
    private String descricao;
    private int codFlags;
    private int codPartigipantes;
    private int codTags;

    public Artigo()
    {

    }

    public Artigo(Long codigo, String titulo, String descricao, int codFlags, int codPartigipantes, int codTags)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.codFlags = codFlags;
        this.codPartigipantes = codPartigipantes;
        this.codTags = codFlags;
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
}
