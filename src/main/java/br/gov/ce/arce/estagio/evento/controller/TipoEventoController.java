package br.gov.ce.arce.estagio.evento.controller;

import br.gov.ce.arce.estagio.evento.repository.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tipo_evento")
public class TipoEventoController {

    @Autowired
    TipoEventoRepository tipoEventoRepository;


    public TipoEventoController() {
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getTipoEventos() {
        return ResponseEntity.ok(tipoEventoRepository.findAll());
    }

}
