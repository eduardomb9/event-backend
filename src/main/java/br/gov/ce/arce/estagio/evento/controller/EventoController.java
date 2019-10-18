package br.gov.ce.arce.estagio.evento.controller;

import br.gov.ce.arce.estagio.evento.exception.EventoException;
import br.gov.ce.arce.estagio.evento.model.Evento;
import br.gov.ce.arce.estagio.evento.model.Participante;
import br.gov.ce.arce.estagio.evento.service.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    private EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getEventos() {
        return ResponseEntity.ok(eventoService.getEventos());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getEventoById(@PathVariable Long id) {
        Evento evento = eventoService.getEventoById(id);
        return ResponseEntity.ok(evento);
    }

    @CrossOrigin
    @RequestMapping(value = "/{eventoId}/participante", method = RequestMethod.GET)
    public List<Participante> getParticipantesByEventoId(@PathVariable Long eventoId) {
        return eventoService.getParticipantesByEventoId(eventoId);
    }

    @CrossOrigin
    @RequestMapping(value = "/{eventoId}/participante", method = RequestMethod.POST)
    public Participante addParticipante(@PathVariable Long eventoId, @RequestBody Participante participante) throws EventoException {
        return eventoService.adicionarParticipante(eventoId, participante);
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addEvento(@RequestBody Evento evento) {
        Evento saved = eventoService.adicionarEvento(evento);
        return ResponseEntity.ok(saved);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removeEvento(@PathVariable("id") Long id) {
        try {
            eventoService.removerEvento(id);
        } catch (EventoException e) {
            ResponseEntity.unprocessableEntity();
        }
        return ResponseEntity.ok("Removido com sucesso.");
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editEvento(@PathVariable("id") Long id,
                                     @RequestBody Evento evento
    ) {
        Evento e = eventoService.editarEvento(id, evento);
        if (e == null) {
            return ResponseEntity.unprocessableEntity().body("Evento com o codigo informado não existente.");
        }
        return ResponseEntity.ok(e);
    }

}
