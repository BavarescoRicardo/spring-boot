package com.ricardotcc.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ricardotcc.spring.model.Noticia;
import com.ricardotcc.spring.repository.NoticiaRepository;


@Service
public class NoticiaServices 
{    
    @Autowired
    private NoticiaRepository noticiaDB;

    public Noticia salvar(Noticia user){
        try {
            return this.noticiaDB.save(user);    
        } catch (Exception e) {
            return null;
        }
        
    }

    public void remove(long idNoticia){
        try {
            this.noticiaDB.deleteById(idNoticia);
        } catch (Exception e) {
        }
        return;
    }

    public List<Noticia> encontrar(){
        Pageable pageable = PageRequest.of(0,5);
        return noticiaDB.findAll(pageable).getContent();
    }

    public List<Noticia> encontrarpg(int pg){
        Pageable pageable = PageRequest.of(pg, 4);
        return noticiaDB.findAll(pageable).getContent();
    }

    public Noticia encontrarPorCodigo(long id) {
        return noticiaDB.findByCodigo(id);
    }

    public void savaImagem(Long idNoticia, MultipartFile files) {
        try {
            Noticia Noticia = this.encontrarPorCodigo(idNoticia);
            
            if((idNoticia == null) || !(Noticia.getCodigo() > 0)){
                throw new Exception("Noticia não encontrado");
            
            }

            // Se excecao nao disparada entao realiza tarefas
            Noticia.setImagem(files.getBytes());
            this.noticiaDB.save(Noticia);    
        } catch (Exception e) {
            return;
        }
    }    
}
    

