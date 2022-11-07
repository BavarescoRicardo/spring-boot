package com.ricardotcc.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardotcc.spring.dto.ParticipanteForm;
import com.ricardotcc.spring.service.ParticipanteServices;

@CrossOrigin
@RestController
public class ParticipanteController {
    @Autowired
    private ParticipanteServices paricipanteServices;

    Logger logger = LoggerFactory.getLogger(ArtigoController.class);

    @RequestMapping(value = "/adiconaparticipantenovo", method =  RequestMethod.POST)
	public ResponseEntity<?> addParticipanteArtigo(@RequestBody ParticipanteForm form)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            paricipanteServices.addParticipante(form.getIdArtigo(), form.getIdUsuario());
            return ResponseEntity.ok().body("Adicionado participante");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }               
	}

    @RequestMapping(value = "/", method =  RequestMethod.POST)
	public ResponseEntity<?> removeParticipanteArtigo(@RequestBody ParticipanteForm form)
    {
        //  envolver metodo em try catch retorno certo no tr retorno erraado no false
        try {
            paricipanteServices.removeParticipante(form.getIdArtigo(), form.getIdUsuario());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }               
	}
    
}