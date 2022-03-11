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
    private LoginRepository login;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login usuario = login.findByNome(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        return (UserDetails) new Login(usuario.getNomelogin(), usuario.getSenhalogin(), authorities(usuario));
    }

    public Collection<? extends GrantedAuthority> authorities(Login usuario) {
        // return authorities(grupos.findByUsuariosIn(Lists.newArrayList(usuario)));
        return null;
    }

    // public Collection<? extends GrantedAuthority> authorities(List<Grupo> grupos) {
    //     Collection<GrantedAuthority> auths = new ArrayList<>();

    //     for (Grupo grupo: grupos) {
    //         List<Permissao> lista = permissoes.findByGruposIn(Lists.newArrayList(grupo));

    //         for (Permissao permissao: lista) {
    //             auths.add(new SimpleGrantedAuthority("ROLE_" + permissao.getNome()));
    //         }
    //     }

    //     return auths;
    // }

}