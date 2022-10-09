package com.ricardotcc.spring.repository;

import com.ricardotcc.spring.model.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<Login, Long>
{
    @Query("select u from Login u where u.nomelogin = ?1 and u.senhalogin = ?2")
    Login findByNomeSenha(String nome, String senha);

    @Query("select u from Login u where u.nomelogin = ?1")
    Login findByNome(String nome);

    @Query("select u from Login u where u.id = ?1")
    Login findByCodigo(Long id);
    
}
