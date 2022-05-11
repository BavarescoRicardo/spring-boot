package com.ricardotcc.spring.controller;

import java.io.IOException;

import com.ricardotcc.spring.model.Usuario;
import com.ricardotcc.spring.service.UsuarioServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioServices userServices;

    // //@PreAuthorize("hasRole('ADMIN')")
    // @RequestMapping(value = "/artigolista", method = RequestMethod.GET)
    // public List<Artigo> GetArtigo() {
    //     return artigoServices.encontrar();
    // }
  
  
//   @PostMapping("/postaFt")
//   public ResponseEntity<Object> handleFileUpload(@RequestParam("file") MultipartFile file) {

//         try {
//             this.userServices.salvarFotoForm(file);
//         } catch (Exception e) {
//             return ResponseEntity.badRequest().body("Erro controller. Não foi possível salvar imagem");
//         }

//         return ResponseEntity.ok("Imagem salva com sucesso");
//   }

    @PostMapping("/postaFt")
    public ResponseEntity<Object> saveFoto(@RequestParam("image") MultipartFile multipartFile) throws IOException {

        try {
            this.userServices.salvarFotoForm(multipartFile);
            //this.userServices.encontrar();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro controller. Não foi possível salvar imagem");
        }

        return ResponseEntity.ok("Imagem salva com sucesso");     
    }

    @RequestMapping(value = "/getusuario", method = RequestMethod.GET)
    public Usuario getUsuario() {
        return userServices.encontrar().get(0);
    }
}