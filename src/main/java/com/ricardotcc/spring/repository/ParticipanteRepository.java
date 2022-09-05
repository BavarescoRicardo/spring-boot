package com.ricardotcc.spring.repository;

import com.ricardotcc.spring.model.Participante;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>
{
    @Query("select u.codArtigo from Participante u where u.codLogin = ?1")
    ArrayList<Long> findByUsuarioCodigo(Long codigo);
}
