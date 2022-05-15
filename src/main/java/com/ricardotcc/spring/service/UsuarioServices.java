package com.ricardotcc.spring.service;

import java.util.List;

import com.ricardotcc.spring.model.Usuario;
import com.ricardotcc.spring.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UsuarioServices 
{    
    @Autowired
    private UsuarioRepository usuarioDB;

    public void salvarFotoForm(MultipartFile img) {
        try {
            List<Usuario> user = usuarioDB.findAll();           
            //String fileName = StringUtils.cleanPath(img.getOriginalFilename());
            
            user.get(0).setFotoPerfil(img.getBytes());
            this.usuarioDB.save(user.get(0));    
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
    
    public void salvarFotoUsuario(MultipartFile img, String nome) {
        try {
            Usuario user = usuarioDB.findByNomeLogin(nome);
            //String fileName = StringUtils.cleanPath(img.getOriginalFilename());
            
            user.setFotoPerfil(img.getBytes());
            this.usuarioDB.save(user);    
        } catch (Exception e) {
            //TODO: handle exception
            return;
        }
    }
}
    

