package com.ricardotcc.spring.service;

import com.ricardotcc.spring.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServices 
{    
    @Autowired
    private LoginRepository loginDB;

    public String Logar(String nome, String senha){
        String result = "naum deu";
        try {
            result =  " Encontrado:  ";
            result += loginDB.findByNomeSenha(nome,  senha).toString();            
        } catch (Exception e) {
            //TODO: handle exception
            result =  " :Exceção:  ";
        }

        return result;
    }
}
    

