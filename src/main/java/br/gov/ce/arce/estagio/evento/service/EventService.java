package br.gov.ce.arce.estagio.evento.service;

import br.gov.ce.arce.estagio.evento.exception.EventException;
import br.gov.ce.arce.estagio.evento.model.Event;
import br.gov.ce.arce.estagio.evento.model.Participant;
import br.gov.ce.arce.estagio.evento.repository.EventRepository;
import br.gov.ce.arce.estagio.evento.repository.ParticipantRepository;
import br.gov.ce.arce.estagio.evento.specification.ParticipantSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Event> getEventos() {
        List<Event> events = new ArrayList<>();
        for (Event e : eventRepository.findAll()) {
            events.add(e);
        }
        return events;
    }

    public Event getEventoById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<Participant> getParticipantesByEventoId(Long eventoId) {
        return participantRepository.findAll(ParticipantSpecification.eventoId(eventoId));
    }

    public Event adicionarEvento(Event event) {
        return eventRepository.save(event);
    }

    public Participant adicionarParticipante(Long eventoId, Participant participant) throws EventException {
        return eventRepository.findById(eventoId).map(evento -> {
            participant.setEvent(evento);
            evento.getParticipants().add(participant);
            return participantRepository.save(participant);
        }).orElseThrow(() -> new EventException("event.cannot.add"));
    }

    public void removerEvento(Long id) throws EventException {
        if (participantRepository.count(ParticipantSpecification.eventoId(id)) == 0) {
            eventRepository.deleteById(id);
        } else {
            throw new EventException("event.cannot.remove");
        }
    }

    public Event editarEvento(Long id, Event event) {
        if (!eventRepository.findById(id).isPresent())
            return null;
        event.setId(id);
        return eventRepository.save(event);
    }

}
