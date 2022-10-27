package com.ricardotcc.spring.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ricardotcc.spring.model.Artigo;
import com.ricardotcc.spring.model.Noticia;
import com.ricardotcc.spring.service.NoticiaServices;

@CrossOrigin
@RestController
@RequestMapping("/noticia")
public class NoticiaController {
    @Autowired
    private NoticiaServices noticiaServices;

    Logger logger = LoggerFactory.getLogger(NoticiaController.class);

    @RequestMapping(value = "/lista", method =  RequestMethod.GET)
    public List<Noticia> GetArtigoPg() {
        return noticiaServices.encontrar();
    }    

    @RequestMapping(value = "/noticia", method = RequestMethod.POST)
    public Noticia GetArtigo(int idArtigo) {
        return noticiaServices.encontrarPorCodigo((long) idArtigo);
    }

    @RequestMapping(value = "/salvar", method =  RequestMethod.POST)
	public Noticia salvarArtigo(@RequestBody Noticia artigo)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
           return this.noticiaServices.salvar(artigo);    
        } catch (Exception e) {
            return null;
        }        
	}

    @RequestMapping(value = "/remover", method =  RequestMethod.POST)
	public ResponseEntity<Object> removerArtigo(Long idArtigo)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
           this.noticiaServices.remove(idArtigo);
           return ResponseEntity.ok("Removido com sucesso");        
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro controller. Não foi remover o artigo");
        }        
	}

    @PostMapping("/imagem")
    public ResponseEntity<Object> savaImagem(int artigo, MultipartFile image) throws IOException {
        try {
            Long idA =  (long) artigo;
            this.noticiaServices.savaImagem(idA, image);
        } catch (Exception e) {
            logger.warn("Erro ao postar imagem ", e.getMessage());
            return ResponseEntity.badRequest().body("Erro controller. Não foi possível salvar imagem");
        }

        return ResponseEntity.ok("Imagem salva com sucesso");     
    }
    
}