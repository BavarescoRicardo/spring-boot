package com.ricardotcc.spring.controller;

import java.io.IOException;
import java.util.List;

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
import com.ricardotcc.spring.model.DetalheArtigo;
import com.ricardotcc.spring.service.ArtigoServices;

@CrossOrigin
@RestController
@RequestMapping("/artigo")
public class ArtigoController {
    @Autowired
    private ArtigoServices artigoServices;

    @RequestMapping(value = "/artigolista", method = RequestMethod.GET)
    public List<Artigo> GetArtigo() {
        return artigoServices.encontrar();
    }

    @RequestMapping(value = "/salvarartigo", method =  RequestMethod.POST)
	public boolean salvarArtigo(@RequestBody Artigo artigo)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            this.artigoServices.salvar(artigo);    
        } catch (Exception e) {
            return false;
        }       
        
        return true;
	}


    @RequestMapping(value = "/artigodettalhe", method = RequestMethod.POST)
    public DetalheArtigo GetDetakhe(int idArtigo) {
        return artigoServices.encontrarDetalhePorCodigo((long) idArtigo);
    }

    @RequestMapping(value = "/salvardetalhe", method =  RequestMethod.POST)
	public boolean salvarDetalheArtigo(@RequestBody DetalheArtigo detalheArtigo)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            this.artigoServices.salvarDetalheArtigo(detalheArtigo);
        } catch (Exception e) {
            return false;
        }       
        
        return true;
	}
    
    @PostMapping("/foto")
    public ResponseEntity<Object> saveFoto(int detalheArtigo, MultipartFile image) throws IOException {
        try {
            Long idA =  (long) detalheArtigo;
            this.artigoServices.salvarFotoForm(idA, image);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro controller. Não foi possível salvar imagem");
        }

        return ResponseEntity.ok("Imagem salva com sucesso");     
    }
    
}