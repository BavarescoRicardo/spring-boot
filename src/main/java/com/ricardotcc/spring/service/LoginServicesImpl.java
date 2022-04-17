package com.ricardotcc.spring.service;

import java.util.List;
import com.ricardotcc.spring.model.Login;
import com.ricardotcc.spring.model.Role;
import com.ricardotcc.spring.repository.LoginRepository;
import com.ricardotcc.spring.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LoginServicesImpl implements LoginServices
{    
    @Autowired
    private LoginRepository loginDB;

    @Autowired
    private RoleRepository roleDB;

    @Override
    public void salvar(Login user){
        try {
            this.loginDB.save(user);    
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    @Override
    public void salvarRole(Role role){
        try {
            roleDB.save(role);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    @Override
    public void adicionarRole(String apelido, String roleName){
        Login login = loginDB.findByNome(apelido);
        Role role = roleDB.findByName(roleName);
        login.getRoles().add(role);

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
    

