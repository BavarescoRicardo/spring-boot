package com.ricardotcc.spring.repository;

import com.ricardotcc.spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
    @Query("select u from Usuario u where u.codigo = ?1")
    Usuario findByCodigo(Long codigo);    

    @Query("select u from Usuario u where u.login.nomelogin = ?1")
    Usuario findByNomeLogin(String nome);

    @Query("select u from Usuario u where u.login.id = ?1")
    Usuario findByIdLogin(Long idLogin);    
}
