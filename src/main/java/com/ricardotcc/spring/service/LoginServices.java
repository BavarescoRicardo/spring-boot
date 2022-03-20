package com.ricardotcc.spring.service;

import java.util.List;

import com.ricardotcc.spring.model.Login;
import com.ricardotcc.spring.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginServices 
{    
    @Autowired
    private LoginRepository loginDB;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void salvar(Login user){
        try {
            this.loginDB.save(user);    
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public String Logar(String nome, String senha){
        String result = "naum deu";
        try {
            result =  " Encontrado:  ";
            result += loginDB.findByNomeSenha(nome,  passwordEncoder.encode(senha)).toString();            
        } catch (Exception e) {
            // result =  " :Exceção:  " + e.getMessage();
            return null;
        }

        return result;
    }

    public List<Login> encontrar(){
        return loginDB.findAll();
    }

}
    

