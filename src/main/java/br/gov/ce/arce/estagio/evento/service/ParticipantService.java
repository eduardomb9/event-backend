package br.gov.ce.arce.estagio.evento.service;

import br.gov.ce.arce.estagio.evento.model.Participant;
import br.gov.ce.arce.estagio.evento.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> getParticipantes() {
        List<Participant> participants = new ArrayList<>();
        for (Participant p : participantRepository.findAll()) {
            participants.add(p);
        }
        return participants;
    }

    public Participant getParticipante(Long id) {
        Optional<Participant> participante = participantRepository.findById(id);
        return participante.orElse(null);
    }

    public Participant addParticipante(Participant participant) {
        return participantRepository.save(participant);
    }

    public void removeParticipante(Long id) {
        this.participantRepository.deleteById(id);
    }

    public Participant editParticipante(Long id, Participant participant) {
        Participant part = participantRepository.findById(id).orElse(null);
        if (part == null) {
            return null;
        } else {
            part.setNome(participant.getNome());
            part = participantRepository.save(part);
        }
        return part;
    }

}
