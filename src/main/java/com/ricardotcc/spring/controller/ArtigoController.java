package com.ricardotcc.spring.controller;

import java.util.List;
import com.ricardotcc.spring.model.Artigo;
import com.ricardotcc.spring.service.ArtigoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
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

    @RequestMapping(value = "/artigodettalhe/{id}", method = RequestMethod.GET)
    public Artigo GetDetakhe() {
        return artigoServices.encontrarPorCodigo((long) 1);
    }

}