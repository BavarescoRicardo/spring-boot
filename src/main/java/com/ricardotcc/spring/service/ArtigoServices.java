package com.ricardotcc.spring.service;

import java.util.List;

import com.ricardotcc.spring.model.Artigo;
import com.ricardotcc.spring.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArtigoServices 
{    
    @Autowired
    private ArtigoRepository artigoDB;

    public void salvar(Artigo user){
        try {
            this.artigoDB.save(user);    
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public List<Artigo> encontrar(){
        return artigoDB.findAll();
    }

    public Artigo  encontrarPorCodigo(long id) {
        return artigoDB.findByCodigo(id);
    }
}
    

