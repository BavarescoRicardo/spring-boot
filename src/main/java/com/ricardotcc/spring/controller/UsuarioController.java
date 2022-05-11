package com.ricardotcc.spring.controller;

import java.io.IOException;

import com.ricardotcc.spring.service.UsuarioServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

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

}