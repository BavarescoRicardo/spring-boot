package com.ricardotcc.spring.controller;

import java.io.IOException;

import com.ricardotcc.spring.model.Usuario;
import com.ricardotcc.spring.service.UsuarioServices;

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
    
}