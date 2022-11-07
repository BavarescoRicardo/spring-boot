package com.ricardotcc.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    private String observacao;
    private byte[] imagem;
    private int codFlags;
    private int codTags;
    private int codCurso;

    @ManyToMany
    @JoinTable(
        name="participantes_Artigo",
        joinColumns = @JoinColumn(name = "artigo_id"),
        inverseJoinColumns = @JoinColumn(name = "participante_id")
    )
    private Set<Usuario> participantesArtigo = new HashSet<>();

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public Artigo()
    {

    }

    public Artigo(String titulo, String descricao, byte[] imagem) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
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

    public Artigo(Long codigo, String titulo, String descricao, int codFlags, int codTags, byte[] imagem)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.codFlags = codFlags;
    }

    public Artigo(Long codigo, String titulo, String descricao, int codFlags, int codTags, byte[] imagem, int codCurso)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.codFlags = codFlags;
        this.codCurso = codCurso;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Set<Usuario> getParticipantesArtigo() {
        return participantesArtigo;
    }

    public void addParticipantes(Usuario u) {
        this.participantesArtigo.add(u);
    }

    public void rmParticipantes(Usuario u) {
        this.participantesArtigo.remove(u);
    }
}
