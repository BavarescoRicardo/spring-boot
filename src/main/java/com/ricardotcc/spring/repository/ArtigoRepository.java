package com.ricardotcc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ricardotcc.spring.model.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Long>
{
    @Query("select u from Artigo u where u.codigo = ?1")
    Artigo findByCodigo(Long codigo);
}
