package com.ricardotcc.spring.repository;

import com.ricardotcc.spring.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{
    // @Query("select u from Login u where u.nomelogin = ?1")
    Role findByName(String name);
}
