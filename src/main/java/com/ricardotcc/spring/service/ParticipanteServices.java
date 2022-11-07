package com.ricardotcc.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardotcc.spring.model.Artigo;
import com.ricardotcc.spring.model.Usuario;
import com.ricardotcc.spring.repository.ArtigoRepository;
import com.ricardotcc.spring.repository.UsuarioRepository;


@Service
public class ParticipanteServices 
{    
    @Autowired
    private ArtigoRepository artigoDB;

    @Autowired
    private UsuarioRepository usuarioDB;

    public void addParticipante(long idArtigo, long idUsuario){
        try {
            Artigo a = this.artigoDB.findByCodigo(idArtigo);
            Usuario user = usuarioDB.findByIdLogin(idUsuario);
            a.addParticipantes(user);
            this.artigoDB.save(a);
        } catch (Exception e) {
        }
    }
    
}
    

