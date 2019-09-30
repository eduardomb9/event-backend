package br.gov.ce.arce.estagio.evento.controller;

import br.gov.ce.arce.estagio.evento.model.Participante;
import br.gov.ce.arce.estagio.evento.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getParticipantes() {
        return ResponseEntity.ok(participanteRepository.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getParticipante(@PathVariable Long id) {
        return ResponseEntity.ok(participanteRepository.findById(id));
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addParticipante(@RequestBody Participante participante) {
        participanteRepository.save(participante);
        return ResponseEntity.ok(participante);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removeParticipante(@PathVariable("id") Long id) {
        this.participanteRepository.deleteById(id);
        return ResponseEntity.ok("evento removido");
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editParticipante(@PathVariable("id") Long id, @RequestBody Participante participante) {
        Optional<Participante> part = participanteRepository.findById(id);
        part.get().setNome(participante.getNome());
        participanteRepository.save(part.get());
        return ResponseEntity.ok("evento alterado");
    }

}
