package com.ricardotcc.spring.security;

import com.ricardotcc.spring.model.Login;
import com.ricardotcc.spring.repository.LoginRepository;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

public class ImplmentUserDetailsService {
    


@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private LoginRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Login usuario = ur.findByNome(login);
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}

}
}
