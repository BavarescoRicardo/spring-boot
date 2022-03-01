package com.ricardotcc.spring.controller;

import java.util.List;

import com.ricardotcc.spring.model.Login;
import com.ricardotcc.spring.repository.LoginRepository;
import com.ricardotcc.spring.service.LoginServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:3033", maxAge = 3600)
@CrossOrigin
@RestController
public class loginController {

    @Autowired
    private LoginRepository userDB;
    @Autowired
    private LoginServices loginServicos;
    // Spring Security

    @RequestMapping(value = "/salvaloginapi", method =  RequestMethod.POST)
	public boolean salvarLogin(@RequestBody Login user)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            this.userDB.save(user);    
        } catch (Exception e) {
            return false;
        }
        
        
        return true;
	}

    @RequestMapping(value = "/fazerloginapi", method =  RequestMethod.POST)
    public String fazerlogin(@RequestBody Login user)
    {
        String resultado;
		resultado = "ponto de controle  ";
        try {
            resultado = loginServicos.Logar(user.getNomelogin(), user.getSenhalogin()); 
        } catch (Exception e) {
            resultado = "Falha ao logar";
        }
        // 
        return resultado;

	}
        
    @RequestMapping(value = "/loginsapi", method = RequestMethod.GET)
    public List<Login> listagenLog() 
    {        
        return this.userDB.findAll();
    }

}