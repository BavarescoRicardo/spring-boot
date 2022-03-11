package com.ricardotcc.spring.security;

import java.util.Collection;

import com.ricardotcc.spring.model.Login;
import com.ricardotcc.spring.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRes;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login usuario = loginRes.findByNome(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        return (UserDetails) new Login(usuario.getNomelogin(), usuario.getSenhalogin(), authorities(usuario));
    }

    public Collection<? extends GrantedAuthority> authorities(Login usuario) {
        // return authorities(grupos.findByUsuariosIn(Lists.newArrayList(usuario)));
        return null;
    }

}