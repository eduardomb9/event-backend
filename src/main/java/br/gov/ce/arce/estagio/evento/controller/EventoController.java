package br.gov.ce.arce.estagio.evento.controller;

import br.gov.ce.arce.estagio.evento.model.Evento;
import br.gov.ce.arce.estagio.evento.model.Participante;
import br.gov.ce.arce.estagio.evento.repository.EventoRepository;
import br.gov.ce.arce.estagio.evento.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    ParticipanteRepository participanteRepository;

    public EventoController() {
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getEventos() {
        return ResponseEntity.ok(eventoRepository.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getEventoById(@PathVariable Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return ResponseEntity.ok(evento.get());
    }

    @CrossOrigin
    @RequestMapping(value = "/{eventoId}/participante", method = RequestMethod.GET)
    public List<Participante> getParticipantesByEventoId(@PathVariable Long eventoId) {
        return participanteRepository.findByEventoId(eventoId);
    }

    @CrossOrigin
    @RequestMapping(value = "/{eventoId}/participante", method = RequestMethod.POST)
    public Participante addParticipante(@PathVariable Long eventoId, @RequestBody Participante participante) {
        return eventoRepository.findById(eventoId).map(evento -> {
            participante.setEvento(evento);
            evento.getParticipantes().add(participante);
            eventoRepository.save(evento);
            return participanteRepository.save(participante);
        }).orElseThrow(() -> new RuntimeException("Evento não encontrado com id do evento: " + eventoId) );
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addEvento(@RequestBody Evento evento) {
        Evento saved = eventoRepository.save(evento);
        return ResponseEntity.ok(saved);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removeEvento(@PathVariable("id") Long id) {
        if (participanteRepository.findByEventoId(id).size() == 0) {
            eventoRepository.deleteById(id);
        } else {
            return ResponseEntity.unprocessableEntity().body("Não foi possivel remover o evento, pois ele tem participantes associados.");
        }
        return ResponseEntity.ok("Evento removido");
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editEvento(@PathVariable("id") Long id,
                                     @RequestBody Evento evento
    ) {
        eventoRepository.save(evento);
        return ResponseEntity.ok("Evento alterado");
    }

}
