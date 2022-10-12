package com.ricardotcc.spring.dto;

public class FiltroArtigoDto {
    private int codCurso;
    private String textoFiltro;
    private String pg;
    
    public String getPg() {
        return pg;
    }
    public void setPg(String pg) {
        this.pg = pg;
    }
    public int getCodCurso() {
        return codCurso;
    }
    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }
    public String getTextoFiltro() {
        return textoFiltro;
    }
    public void setTextoFiltro(String textoFiltro) {
        this.textoFiltro = textoFiltro;
    }
}