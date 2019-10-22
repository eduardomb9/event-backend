package br.gov.ce.arce.estagio.evento.controller;

import br.gov.ce.arce.estagio.evento.service.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/tipo_evento")
public class TipoEventoController {

    private TipoEventoService tipoEventoService;

    @Autowired
    public TipoEventoController(TipoEventoService service) {
        this.tipoEventoService = service;
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getTipoEventos() {
        return ResponseEntity.ok(tipoEventoService.getTiposEventos());
    }

}
