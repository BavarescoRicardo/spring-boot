package com.ricardotcc.spring.dto;

public class FiltroArtigoDto {
    private long codCurso;
    private String textoFiltro;
    
    public long getCodCurso() {
        return codCurso;
    }
    public void setCodCurso(long codCurso) {
        this.codCurso = codCurso;
    }
    public String getTextoFiltro() {
        return textoFiltro;
    }
    public void setTextoFiltro(String textoFiltro) {
        this.textoFiltro = textoFiltro;
    }
}