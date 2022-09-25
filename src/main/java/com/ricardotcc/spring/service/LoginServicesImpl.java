package com.ricardotcc.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.ricardotcc.spring.model.Login;
import com.ricardotcc.spring.model.Role;
import com.ricardotcc.spring.repository.LoginRepository;
import com.ricardotcc.spring.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LoginServicesImpl implements LoginServices, UserDetailsService
{    
    @Autowired
    private LoginRepository loginDB;

    @Autowired
    private RoleRepository roleDB;

    @Autowired
    private PasswordEncoder passwordEncode;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginDB.findByNome(username);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        login.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
    });

        return new org.springframework.security.core.userdetails.User(
            login.getNomelogin(), login.getPassword(), authorities);
    }

    @Override
    public void salvar(Login user){
        try {
            user.setSenhalogin(passwordEncode.encode(user.getPassword())); 
            this.loginDB.save(user);    
        } catch (Exception e) {
        }
    }

    @Override
    public void remover(Long idUser){
        try {
            this.loginDB.deleteById(idUser);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void salvarRole(Role role){
        try {
            roleDB.save(role);
        } catch (Exception e) {
        }
    }
    @Override
    public void adicionarRole(String apelido, String roleName){
        Login login = loginDB.findByNome(apelido);
        Role role = roleDB.findByName(roleName);
        login.getRoles().add(role);

    }

    @Override
    public void removerRole(String apelido, String roleName){
        Login login = loginDB.findByNome(apelido);
        Role role = roleDB.findByName(roleName);
        //login.getRoles().add(role);
        login.getRoles().remove(role);

    }

    @Override
    public Login getLogin(String apelido){
        
        return loginDB.findByNome(apelido);
    }

    @Override
    public String Logar(String nome, String senha){
        String result = "naum deu";
        try {
            result =  " Encontrado:  ";
            result += loginDB.findByNomeSenha(nome,  senha).toString();            
        } catch (Exception e) {
            // result =  " :Exceção:  " + e.getMessage();
            return null;
        }

        return result;
    }

    @Override
    public List<Login> encontrar(){
        return loginDB.findAll();
    }

}
    

