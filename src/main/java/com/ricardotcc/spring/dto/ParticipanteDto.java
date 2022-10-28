package com.ricardotcc.spring.dto;


public class ParticipanteDto {


    private Long id;
    private Long codLogin;
    private Long codArtigo;
    public Long getCodArtigo() {
        return codArtigo;
    }

    public void setCodArtigo(Long codArtigo) {
        this.codArtigo = codArtigo;
    }

    public ParticipanteDto() 
    {

    }

    public ParticipanteDto(Long id, Long codLogin, Long codArtigo)
    {
        this.id = id;
        this.codLogin = codLogin;
        this.codArtigo = codArtigo;
    }

    public Long getId() {
        return id;
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
