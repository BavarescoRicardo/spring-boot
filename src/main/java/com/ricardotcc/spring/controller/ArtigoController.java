package com.ricardotcc.spring.controller;

import java.io.IOException;
import java.util.List;

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

import com.ricardotcc.spring.dto.ArtigoDto;
import com.ricardotcc.spring.dto.FiltroArtigoDto;
import com.ricardotcc.spring.model.Artigo;
import com.ricardotcc.spring.model.DetalheArtigo;
import com.ricardotcc.spring.service.ArtigoServices;

@CrossOrigin
@RestController
@RequestMapping("/artigo")
public class ArtigoController {
    @Autowired
    private ArtigoServices artigoServices;

    Logger logger = LoggerFactory.getLogger(ArtigoController.class);

    @RequestMapping(value = "/artigolista", method =  RequestMethod.GET)
    public List<Artigo> GetArtigoPg(int pg) {
        return artigoServices.encontrarpg(pg);
    }

    @RequestMapping(value = "/artigolista", method =  RequestMethod.GET)
    public List<Artigo> GetArtigoFiltrando(@RequestBody FiltroArtigoDto filtro){
        return artigoServices.encontrarpg(filtro);
    }

    @RequestMapping(value = "/artigolistaparticipante", method = RequestMethod.GET)
    public List<ArtigoDto> GetArtigosParticipante() {
        return artigoServices.encontrarArtigosParticipante();
    }

    @RequestMapping(value = "/salvarartigo", method =  RequestMethod.POST)
	public Artigo salvarArtigo(@RequestBody Artigo artigo)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
           return this.artigoServices.salvar(artigo);    
        } catch (Exception e) {
            return null;
        }        
	}

    @RequestMapping(value = "/remover", method =  RequestMethod.POST)
	public ResponseEntity<Object> removerArtigo(Long idArtigo)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
           this.artigoServices.remove(idArtigo);
           return ResponseEntity.ok("Removido com sucesso");        
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro controller. Não foi remover o artigo");
        }        
	}

    @RequestMapping(value = "/artigodettalhe", method = RequestMethod.POST)
    public List<DetalheArtigo> GetDetalhe(int idArtigo) {
        return artigoServices.encontrarDetalhePorCodigo((long) idArtigo);
    }

    @RequestMapping(value = "/artigo", method = RequestMethod.POST)
    public Artigo GetArtigo(int idArtigo) {
        return artigoServices.encontrarPorCodigo((long) idArtigo);
    }    

    @RequestMapping(value = "/removerdetalhe", method = RequestMethod.POST)
    public boolean DeletaDetalhe(int idArtigo) {
        try {
            artigoServices.RemoveDetalhePorCodigo((long) idArtigo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(value = "/salvardetalhe", method =  RequestMethod.POST)
	public ResponseEntity<DetalheArtigo> salvarDetalheArtigo(@RequestBody DetalheArtigo detalheArtigo)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            return ResponseEntity.ok().body(this.artigoServices.salvarDetalheArtigo(detalheArtigo));
        } catch (Exception e) {
            return null;
        }       
        
	}
    
    @PostMapping("/foto")
    public ResponseEntity<Object> saveFoto(int detalheArtigo, MultipartFile image) throws IOException {
        try {
            Long idA =  (long) detalheArtigo;
            this.artigoServices.salvarFotoForm(idA, image);
        } catch (Exception e) {
            logger.warn("Erro ao postar imagem ", e.getMessage());
            return ResponseEntity.badRequest().body("Erro controller. Não foi possível salvar imagem");
        }

        return ResponseEntity.ok("Imagem salva com sucesso");     
    }

    @PostMapping("/imagem")
    public ResponseEntity<Object> savaImagem(int artigo, MultipartFile image) throws IOException {
        try {
            Long idA =  (long) artigo;
            this.artigoServices.savaImagem(idA, image);
        } catch (Exception e) {
            logger.warn("Erro ao postar imagem ", e.getMessage());
            return ResponseEntity.badRequest().body("Erro controller. Não foi possível salvar imagem");
        }

        return ResponseEntity.ok("Imagem salva com sucesso");     
    }
    
}