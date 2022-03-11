package com.ricardotcc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.ricardotcc.spring.model.Artigo;

public interface ArtigoRepositorio extends JpaRepository<Artigo, Long>
{
    @Query("select u from Artigo u where u.codigo = ?1")
    List<Artigo> findByCodigo(Long codigo);
}
