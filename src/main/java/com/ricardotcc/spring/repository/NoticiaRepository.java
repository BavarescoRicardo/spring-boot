package com.ricardotcc.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ricardotcc.spring.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long>
{
    List<Noticia> findAll();

    Page<Noticia> findAll(Pageable p);

    @Query("select u from Noticia u where u.codigo = ?1")
    Noticia findByCodigo(Long codigo);
}
