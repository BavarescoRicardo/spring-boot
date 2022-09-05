package com.ricardotcc.spring.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.ricardotcc.spring.model.Usuario;
import com.ricardotcc.spring.service.UsuarioServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioServices userServices;

    Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    @PostMapping("/postaFt")
    public ResponseEntity<Object> saveFoto(@RequestParam("image") MultipartFile multipartFile, Authentication auth) throws IOException {

        try {
            this.userServices.salvarFotoForm(multipartFile, auth);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro controller. Não foi possível salvar imagem");
        }

        return ResponseEntity.ok("Imagem salva com sucesso");     
    }

    @RequestMapping(value = "/getusuario", method = RequestMethod.GET)
    public Usuario getUsuario() {
        return userServices.encontrar().get(0);
    }

    @RequestMapping(value = "/selusuario", method =  RequestMethod.GET)
	public Usuario selecionaUsuario(Authentication auth)
    {
        try {
            logger.warn("selecionado usuario: " + auth.getPrincipal().toString());
            return userServices.selecionaUsuarioAutenticado(auth);
        } catch (Exception e) {
            return null;
        }               
	}

    @RequestMapping(value = "/salvausuario", method =  RequestMethod.POST)
	public boolean salvarLogin(@RequestBody Usuario user, Authentication auth)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            userServices.salvar(user, auth);
        } catch (Exception e) {
            return false;
        }               
        return true;
	}


    @RequestMapping(value = "/adiconaparticipante", method =  RequestMethod.POST)
	public ResponseEntity<?> addParticipanteArtigo(@RequestBody ParticipanteForm form)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            userServices.addParticipante(form.getIdArtigo(), form.getIdUsuario());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }               
	}

    @RequestMapping(value = "/selparticipantes", method = RequestMethod.POST)
    public ArrayList<Long> getParticipantes(int idUsuario) {
        return userServices.encontrarParticipante((long) idUsuario);
    }
    
}

class ParticipanteForm {
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