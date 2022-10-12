package com.ricardotcc.spring.service;

import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ricardotcc.spring.dto.ArtigoDto;
import com.ricardotcc.spring.dto.FiltroArtigoDto;
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
            return null;
        }
        
    }

    public void remove(long idArtigo){
        try {
            this.artigoDB.deleteById(idArtigo);
        } catch (Exception e) {
        }
        return;
    }

    public List<Artigo> encontrar(){
        Pageable pageable = PageRequest.of(0,5);
        return artigoDB.findAll(pageable).getContent();
    }

    public List<Artigo> encontrarpg(int pg){
        Pageable pageable = PageRequest.of(pg, 4);
        return artigoDB.findAll(pageable).getContent();
    }

    public List<Artigo> encontrarFiltrado(FiltroArtigoDto filtro){
        Pageable pageable = PageRequest.of(Integer.parseInt(filtro.getPg()), 4);
        return artigoDB.findAllFiltrado(filtro.getCodCurso(), filtro.getTextoFiltro(), pageable).getContent();
    }

    public List<Artigo> encontrarpg(FiltroArtigoDto filtro){
        Pageable pageable = PageRequest.of(0, 4);
        return artigoDB.findAll(pageable).getContent();
    }

    public List<ArtigoDto> encontrarArtigosParticipante(){
        return artigoDB.findArtigosParticipante();
    }

    public Artigo encontrarPorCodigo(long id) {
        return artigoDB.findByCodigo(id);
    }

    public List<DetalheArtigo> encontrarDetalhePorCodigoArtigo(long id) {
        return detalheDB.findByArtigoCodigo(id);
    }

    public DetalheArtigo encontrarDetalhePorCodigoDetalhe(long id) {
        return detalheDB.findByCodigo(id);
    }

    public boolean RemoveDetalhePorCodigo(long id) {        
        try {
            detalheDB.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public DetalheArtigo salvarDetalheArtigo(DetalheArtigo detalheArtigo){
        try {
            return this.detalheDB.save(detalheArtigo);    
        } catch (Exception e) {
            return null;
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
            DetalheArtigo detalhe = this.detalheDB.findByCodigo(detalheArtigo);
            
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
    

