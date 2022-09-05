package com.ricardotcc.spring.dto;

public class ParticipanteForm {
    private long idArtigo;
    private long idUsuario;

    public long getIdArtigo() {
        return idArtigo;
    }
    public void setIdArtigo(long idArtigo) {
        this.idArtigo = idArtigo;
    }
    public long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}