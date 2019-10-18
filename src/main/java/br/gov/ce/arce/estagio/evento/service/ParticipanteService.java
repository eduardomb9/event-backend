package br.gov.ce.arce.estagio.evento.service;

import br.gov.ce.arce.estagio.evento.model.Participante;
import br.gov.ce.arce.estagio.evento.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Participante> getParticipantes() {
        List<Participante> participantes = new ArrayList<>();
        for (Participante p : participanteRepository.findAll()) {
            participantes.add(p);
        }
        return participantes;
    }

    public Participante getParticipante(Long id) {
        return participanteRepository.findById(id).get();
    }

    public Participante addParticipante(Participante participante) {
        Participante participanteSalvo = participanteRepository.save(participante);
        return participanteSalvo;
    }

    public void removeParticipante(Long id) {
        this.participanteRepository.deleteById(id);
    }

    public Participante editParticipante(Long id, Participante participante) {
        Participante part = participanteRepository.findById(id).get();
        if (part == null) {
            return null;
        } else {
            part.setNome(participante.getNome());
            part = participanteRepository.save(part);
        }
        return part;
    }

}
