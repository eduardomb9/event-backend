package br.gov.ce.arce.estagio.evento.controller;

import br.gov.ce.arce.estagio.evento.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/tipo_evento")
@CrossOrigin
public class EventTypeController {

    private EventTypeService eventTypeService;

    @Autowired
    public EventTypeController(EventTypeService service) {
        this.eventTypeService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getTipoEventos() {
        return ResponseEntity.ok(eventTypeService.getTiposEventos());
    }

}
