package br.gov.ce.arce.estagio.evento.controller;

import br.gov.ce.arce.estagio.evento.model.Participant;
import br.gov.ce.arce.estagio.evento.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participante")
public class ParticipantController {

    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getParticipantes() {
        return ResponseEntity.ok(participantService.getParticipantes());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getParticipante(@PathVariable Long id) {
        return ResponseEntity.ok(participantService.getParticipante(id));
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addParticipante(@RequestBody Participant participant) {
        participant = participantService.addParticipante(participant);
        return ResponseEntity.ok(participant);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removeParticipante(@PathVariable("id") Long id) {
        this.participantService.removeParticipante(id);
        return ResponseEntity.ok("evento removido");
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editParticipante(@PathVariable("id") Long id, @RequestBody Participant participant) {
        Participant p = participantService.editParticipante(id, participant);
        return ResponseEntity.ok(p);
    }

}
