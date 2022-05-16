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

    @RequestMapping(value = "/getusuario", method = RequestMethod.GET)
    public Usuario getUsuario() {
        return userServices.encontrar().get(0);
    }

    @RequestMapping(value = "/selusuario", method =  RequestMethod.POST)
	public Usuario selecionaUsuario(@RequestBody String nome)
    {
        try {
            return userServices.selecionaUsuarioLogin(nome.substring(0, nome.length() - 1));
        } catch (Exception e) {
            return null;
        }               
	}

    @PostMapping("/userPostaFt")
    public ResponseEntity<Object> usuarioSaveFoto(@RequestParam("image") MultipartFile multipartFile, Authentication authentication) throws IOException {

        try {
            this.userServices.salvarFotoUsuario(multipartFile, authentication.getPrincipal().toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro controller. Não foi possível salvar imagem");
        }

        return ResponseEntity.ok("Imagem salva com sucesso");     
    }
    
}