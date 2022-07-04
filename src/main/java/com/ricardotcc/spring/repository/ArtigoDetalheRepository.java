package com.ricardotcc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ricardotcc.spring.model.DetalheArtigo;

public interface ArtigoDetalheRepository extends JpaRepository<DetalheArtigo, Long>
{
    @Query("select u from DetalheArtigo u where u.codigo = ?1")
    DetalheArtigo findByCodigo(Long codigo);

    @Query("select u from DetalheArtigo u where u.codArtigo = ?1")
    DetalheArtigo findByArtigoCodigo(Long codigo);
}
