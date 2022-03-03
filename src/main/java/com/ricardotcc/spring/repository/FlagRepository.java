package com.ricardotcc.spring.repository;

import com.ricardotcc.spring.model.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlagRepository extends JpaRepository<Login, Long>
{
    // @Query("select u from Login u where u.nomelogin = ?1")
    // Login findByNome(String nome);    
}
