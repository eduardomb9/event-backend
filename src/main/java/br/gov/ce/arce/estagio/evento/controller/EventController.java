package br.gov.ce.arce.estagio.evento.controller;

import br.gov.ce.arce.estagio.evento.exception.EventException;
import br.gov.ce.arce.estagio.evento.model.Event;
import br.gov.ce.arce.estagio.evento.model.Participant;
import br.gov.ce.arce.estagio.evento.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/evento")
@CrossOrigin
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getEventos() {
        return ResponseEntity.ok(eventService.getEventos());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Event> getEventoById(@PathVariable Long id) {
        Event event = eventService.getEventoById(id);
        return ResponseEntity.ok(event);
    }

    @RequestMapping(value = "/{eventoId}/participante", method = RequestMethod.GET)
    public List<Participant> getParticipantesByEventoId(@PathVariable Long eventoId) {
        return eventService.getParticipantesByEventoId(eventoId);
    }

    @RequestMapping(value = "/{eventoId}/participante", method = RequestMethod.POST)
    public Participant addParticipante(@PathVariable Long eventoId, @RequestBody Participant participant) throws EventException {
        return eventService.adicionarParticipante(eventoId, participant);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Event> addEvento(@RequestBody Event event) {
        Event saved = eventService.adicionarEvento(event);
        return ResponseEntity.ok(saved);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeEvento(@PathVariable("id") Long id) {
        eventService.removerEvento(id);
        return ResponseEntity.ok("Removido com sucesso.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Event> editEvento(@PathVariable("id") Long id,
                                            @RequestBody Event event
    ) {
        Event e = eventService.editarEvento(id, event);
        if (e == null) {
            throw new EventException("Evento com o codigo informado não existente.");
        }
        return ResponseEntity.ok(e);
    }

}
