package com.ricardotcc.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ricardotcc.spring.model.Participante;
import com.ricardotcc.spring.model.Usuario;
import com.ricardotcc.spring.repository.ParticipanteRepository;
import com.ricardotcc.spring.repository.UsuarioRepository;


@Service
public class UsuarioServices 
{    
    @Autowired
    private UsuarioRepository usuarioDB;

    @Autowired
    private ParticipanteRepository participanteDB;

    @Autowired
    private LoginServicesImpl loginServicos;    

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
            return;
        }
    }

    public List<Usuario> encontrar(){
        return usuarioDB.findAll();
    }

    public Usuario selecionaUsuario(Long codigo){
        return usuarioDB.findByCodigo(codigo);
    }

    public Usuario selecionaUsuarioAutenticado(Authentication auth){
        UserDetails userd = (UserDetails)auth.getPrincipal();
        return usuarioDB.findByNomeLogin(userd.getUsername());
    }

    
    public void salvar(Usuario user, Authentication auth){
        try {
            UserDetails userd = (UserDetails)auth.getPrincipal();            
            user.setLogin(loginServicos.getLogin(userd.getUsername()));
            this.usuarioDB.save(user);    
        } catch (Exception e) {
        }
    }

    public void removeUsuariopeloLogin(Long idLogin){
        try {
            this.usuarioDB.delete(
                this.usuarioDB.findByIdLogin(idLogin));
        } catch (Exception e) {
        }
    }

    public void removeParticipante(long idArtigo, long idUsuario){
        try {
            Participante p = new Participante();

            p = this.participanteDB.findParticipanteByUsuarioArtigo(idUsuario, idArtigo);
            this.participanteDB.delete(p);
        } catch (Exception e) {
        }
    }

    public void addParticipante(long idArtigo, long idUsuario){
        try {
            Participante p = new Participante();
            p.setCodArtigo(idArtigo);
            p.setCodUlogin(idUsuario);
            this.participanteDB.save(p);
        } catch (Exception e) {
        }
    }

    public ArrayList<Long> encontrarParticipante(long id) {
        try {
            ArrayList<Long> listaIdsArtigos = new ArrayList<Long>();
            listaIdsArtigos = this.participanteDB.findByUsuarioCodigo(id);
    
            return listaIdsArtigos;            
        } catch (Exception e) {
            return null;
        }

    }

    public boolean verificaParticipante(long idArtigo, Authentication auth){
        try {
            ArrayList<Long> listaIdsArtigos = new ArrayList<Long>();
            UserDetails userd = (UserDetails)auth.getPrincipal();
            Usuario usuario = usuarioDB.findByNomeLogin(userd.getUsername());
            long idUsuario = usuario.getLogin().getId();
            listaIdsArtigos = this.participanteDB.findByUsuarioCodigo(idUsuario);            
            
            // Verifica se id do artigo existe na lista
            return listaIdsArtigos.contains(idArtigo);
        } catch (Exception e) {
            return false;
        }
    }

}
    

