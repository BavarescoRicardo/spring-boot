package com.ricardotcc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ricardotcc.spring.model.Artigo;

public interface ArtigoRepositorio extends JpaRepository<Artigo, Long>
{
    // <named-query name="User.findByLastname">
    //     <query>select u from User u where u.lastname = ?1</query>
    // </named-query>
    
}
