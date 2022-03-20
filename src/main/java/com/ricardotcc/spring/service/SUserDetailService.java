package com.ricardotcc.spring.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import com.ricardotcc.spring.model.Login;
import com.ricardotcc.spring.model.Role;
import com.ricardotcc.spring.repository.LoginRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SUserDetailService implements UserDetailsService {

    private LoginRepository loginRepository;

    public SUserDetailService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Login login = loginRepository.findByNome(username);
            if (login == null)
                return null;
            
            return new org.springframework.security.core.userdetails.User(
                login.getNomelogin(), login.getPassword(), getAuthories(login));
        }
        catch (Exception e) {
            throw new UsernameNotFoundException("Nao encontrado");
        }
    }

    private Set<GrantedAuthority> getAuthories(Login login) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role: login.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getNomeRole());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
    
}
