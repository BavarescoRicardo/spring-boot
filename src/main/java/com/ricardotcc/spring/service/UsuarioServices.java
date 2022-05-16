package com.ricardotcc.spring.service;

import java.util.List;

import com.ricardotcc.spring.model.Usuario;
import com.ricardotcc.spring.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UsuarioServices 
{    
    @Autowired
    private UsuarioRepository usuarioDB;

    public void salvarFotoForm(MultipartFile img, Authentication auth) {
        try {
            UserDetails userd = (UserDetails)auth.getPrincipal();
            Usuario usuario = usuarioDB.findByNomeLogin(userd.getUsername());
            
            if(usuario == null){
                throw new Exception("Usuario não encontrado");
            }
            usuario.setFotoPerfil(img.getBytes());
            this.usuarioDB.save(usuario);    
        } catch (Exception e) {
            //TODO: handle exception
            return;
        }
    }

    public List<Usuario> encontrar(){
        return usuarioDB.findAll();
    }

    public Usuario selecionaUsuario(Long codigo){
        return usuarioDB.findByCodigo(codigo);
    }

    public Usuario selecionaUsuarioLogin(String nome){
        return usuarioDB.findByNomeLogin(nome);
    }

}
    

