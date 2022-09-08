package com.ricardotcc.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ricardotcc.spring.model.Artigo;
import com.ricardotcc.spring.model.DetalheArtigo;
import com.ricardotcc.spring.repository.ArtigoDetalheRepository;
import com.ricardotcc.spring.repository.ArtigoRepository;


@Service
public class ArtigoServices 
{    
    @Autowired
    private ArtigoRepository artigoDB;

    @Autowired
    private ArtigoDetalheRepository detalheDB;

    public Artigo salvar(Artigo user){
        try {
            return this.artigoDB.save(user);    
        } catch (Exception e) {
        }
        return null;
    }

    public void remove(long idArtigo){
        try {
            this.artigoDB.deleteById(idArtigo);
        } catch (Exception e) {
        }
        return;
    }

    public List<Artigo> encontrar(){
        return artigoDB.findAll();
    }

    public Artigo encontrarPorCodigo(long id) {
        return artigoDB.findByCodigo(id);
    }

    public List<DetalheArtigo> encontrarDetalhePorCodigo(long id) {
        return detalheDB.findByArtigoCodigo(id);
    }

    public boolean RemoveDetalhePorCodigo(long id) {        
        try {
            detalheDB.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void salvarDetalheArtigo(DetalheArtigo detalheArtigo){
        try {
            this.detalheDB.save(detalheArtigo);    
        } catch (Exception e) {
        }
    }

    public void savaImagem(Long idArtigo, MultipartFile files) {
        try {
            Artigo artigo = this.encontrarPorCodigo(idArtigo);
            
            if((idArtigo == null) || !(artigo.getCodigo() > 0)){
                throw new Exception("Artigo não encontrado");
            
            }

            // Se excecao nao disparada entao realiza tarefas
            artigo.setImagem(files.getBytes());
            this.artigoDB.save(artigo);    
        } catch (Exception e) {
            return;
        }
    }

    public void salvarFotoForm(Long detalheArtigo, MultipartFile files) {
        try {
            DetalheArtigo detalhe = this.encontrarDetalhePorCodigo(detalheArtigo).get(0);
            
            if((detalhe == null) || !(detalhe.getCodigo() > 0)){
                throw new Exception("Artigo não encontrado");
            
            }

            // Se excecao nao disparada entao realiza tarefas
            detalhe.setfotoPublicacao(files.getBytes());
            this.detalheDB.save(detalhe);    
        } catch (Exception e) {
            return;
        }
    }
    
}
    

