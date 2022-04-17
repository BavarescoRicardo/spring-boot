package com.ricardotcc.spring.service;

import java.util.List;

import com.ricardotcc.spring.model.Login;
import com.ricardotcc.spring.model.Role;

public interface LoginServices {
     void salvar(Login user);

    void salvarRole(Role role);
        
    void adicionarRole(String apelido, String roleName);
    
    Login getLogin(String apelido);
    
    String Logar(String nome, String senha);
    
    List<Login> encontrar();
}
