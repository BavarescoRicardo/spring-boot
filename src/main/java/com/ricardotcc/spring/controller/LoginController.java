package com.ricardotcc.spring.controller;

import java.util.List;

import com.ricardotcc.spring.model.Login;
import com.ricardotcc.spring.model.Role;
import com.ricardotcc.spring.dto.RoleToUserForm;
import com.ricardotcc.spring.service.LoginServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private LoginServicesImpl loginServicos;    

    @RequestMapping(value = "/salvaloginapi", method =  RequestMethod.POST)
	public boolean salvarLogin(@RequestBody Login user)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            loginServicos.salvar(user);
        } catch (Exception e) {
            return false;
        }               
        return true;
	}

    @RequestMapping(value = "/removerloginapi", method =  RequestMethod.POST)
	public ResponseEntity<?> removerLogin(Long idLogin)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            loginServicos.remover(idLogin);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não localizou login.. "+e.getMessage());
        }               
        return ResponseEntity.ok().body("Removido com sucesso");
	}

    @RequestMapping(value = "/mudarsenhalogin", method =  RequestMethod.POST)
	public ResponseEntity<?> mudarSenhaLogin(Long idLogin, String senhaNova)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            loginServicos.mudarSenhaLogin(idLogin, senhaNova);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não localizou login.. "+e.getMessage());
        }               
        return ResponseEntity.ok().body("Senha alterada com sucesso");
	}

    @RequestMapping(value = "/adicionaroleapi", method =  RequestMethod.POST)
	public ResponseEntity<?> adicionaRole(@RequestBody RoleToUserForm form)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            loginServicos.adicionarRole(form.getUsername(), form.getRoleName());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }               
	}

    @RequestMapping(value = "/removerroleapi", method =  RequestMethod.POST)
	public ResponseEntity<?> removerRole(@RequestBody RoleToUserForm form)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            loginServicos.removerRole(form.getUsername(), form.getRoleName());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }               
	}

    @RequestMapping(value = "/salvarolenapi", method =  RequestMethod.POST)
	public boolean salvarRole(@RequestBody Role role)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            loginServicos.salvarRole(role);
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
        return this.loginServicos.encontrar();
    }

    @RequestMapping(value = "/iniciarrolesapi", method =  RequestMethod.GET)
	public ResponseEntity<?> adicionaAutoRemotoRole()
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            loginServicos.removerRole(null, null);

            loginServicos.salvarRole(new Role(Long.parseLong("1"), "ROLE_USER"));
            loginServicos.salvarRole(new Role(Long.parseLong("2"), "ROLE_ADMIN"));
            loginServicos.salvarRole(new Role(Long.parseLong("3"), "ROLE_SUPERADMIN"));

            loginServicos.adicionarRole("ricardo", "ROLE_USER");
            loginServicos.adicionarRole("ricardo", "ROLE_ADMIN");
            //loginServicos.adicionarRole("masterr", "ROLE_SUPERADMIN");

            loginServicos.adicionarRole("admin", "ROLE_ADMIN");

            return ResponseEntity.ok().body("Executadas açoes com sucesso absoluto!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar role no banco de dados  " + e.getMessage());
        }               
	}
    
}



