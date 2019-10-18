package br.gov.ce.arce.estagio.evento.controller;

import br.gov.ce.arce.estagio.evento.model.Participante;
import br.gov.ce.arce.estagio.evento.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    private ParticipanteService participanteService;

    @Autowired
    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getParticipantes() {
        return ResponseEntity.ok(participanteService.getParticipantes());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getParticipante(@PathVariable Long id) {
        return ResponseEntity.ok(participanteService.getParticipante(id));
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addParticipante(@RequestBody Participante participante) {
        participante = participanteService.addParticipante(participante);
        return ResponseEntity.ok(participante);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removeParticipante(@PathVariable("id") Long id) {
        this.participanteService.removeParticipante(id);
        return ResponseEntity.ok("evento removido");
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editParticipante(@PathVariable("id") Long id, @RequestBody Participante participante) {
        Participante p = participanteService.editParticipante(id, participante);
        return ResponseEntity.ok(p);
    }

}
