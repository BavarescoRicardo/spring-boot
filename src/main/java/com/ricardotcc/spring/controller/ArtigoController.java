package com.ricardotcc.spring.controller;

import java.util.List;
import com.ricardotcc.spring.model.Artigo;
import com.ricardotcc.spring.repository.ArtigoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class ArtigoController {
    @Autowired
    private ArtigoRepositorio artigoRepositorio;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/artigolista", method = RequestMethod.GET)
    public List<Artigo> GetArtigo() {
        return artigoRepositorio.findAll();
    }

    @RequestMapping(value = "/salvarartigo", method =  RequestMethod.POST)
	public boolean salvarArtigo(@RequestBody Artigo artigo)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            this.artigoRepositorio.save(artigo);    
        } catch (Exception e) {
            return false;
        }
        
        
        return true;
	}

    @RequestMapping(value = "/artigodettalhe/{id}", method = RequestMethod.GET)
    public List<Artigo> GetDetakhe() {
        return artigoRepositorio.findByCodigo((long) 1);
    }

}