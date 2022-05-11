package com.ricardotcc.spring.repository;

import com.ricardotcc.spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
    @Query("select u from Usuario u where u.codigo = ?1")
    Usuario findByCodigo(Long codigo);    
}
