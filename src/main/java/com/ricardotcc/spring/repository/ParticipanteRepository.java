package com.ricardotcc.spring.repository;

import com.ricardotcc.spring.model.Participante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>
{
    // @Query("select u from Login u where u.nomelogin = ?1")
    // Login findByNome(String nome);    
}
