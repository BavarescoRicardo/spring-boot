package com.ricardotcc.spring.repository;

import com.ricardotcc.spring.model.Participante;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>
{
    @Query("select u.codArtigo from Participante u where u.codLogin = ?1")
    ArrayList<Long> findByUsuarioCodigo(Long codigo);

    @Query("select u from Participante u where u.codLogin = ?1 AND u.codArtigo = ?2")
    Participante findParticipanteByUsuarioArtigo(Long codigoUsuario, Long codigoArtigo);

    @Query("select u from Participante u where u.codArtigo = ?1")
    List<Participante> findParticipanteByArtigo(Long idArtigo);
}
