package com.ricardotcc.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ricardotcc.spring.dto.ArtigoDto;
import com.ricardotcc.spring.model.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Long>
{
    List<Artigo> findAll();

    Page<Artigo> findAll(Pageable p);

    @Query("select u from Artigo u where u.codigo = ?1")
    Artigo findByCodigo(Long codigo);

    @Query("select new com.ricardotcc.spring.dto.ArtigoDto (a.codigo, a.titulo) from Artigo a")
    List<Artigo> findArtigosParticipante();
}
