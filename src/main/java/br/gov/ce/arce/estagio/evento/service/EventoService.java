package br.gov.ce.arce.estagio.evento.service;

import br.gov.ce.arce.estagio.evento.exception.EventoException;
import br.gov.ce.arce.estagio.evento.model.Evento;
import br.gov.ce.arce.estagio.evento.model.Participante;
import br.gov.ce.arce.estagio.evento.repository.EventoRepository;
import br.gov.ce.arce.estagio.evento.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    ParticipanteRepository participanteRepository;

    public List<Evento> getEventos() {
        List<Evento> eventos = new ArrayList<>();
        for (Evento e : eventoRepository.findAll()) {
            eventos.add(e);
        }
        return eventos;
    }

    public Evento getEventoById(Long id) {
        return eventoRepository.findById(id).get();
    }

    public List<Participante> getParticipantesByEventoId(Long eventoId) {
        return participanteRepository.findByEventoId(eventoId);
    }

    public Evento adicionarEvento(Evento evento) {
        Evento saved = eventoRepository.save(evento);
        return saved;
    }

    public Participante adicionarParticipante(Long eventoId, Participante participante) throws EventoException {
        return eventoRepository.findById(eventoId).map(evento -> {
            participante.setEvento(evento);
            evento.getParticipantes().add(participante);
            return participanteRepository.save(participante);
        }).orElseThrow(() -> new EventoException(EventoException.MSG_EXCEPTION_ADICIONAR_PARTICIPANTE_EVENTO_INEXISTENTE));
    }

    public void removerEvento(Long id) throws EventoException {
        if (participanteRepository.findByEventoId(id).size() == 0) {
            eventoRepository.deleteById(id);
        } else {
            throw new EventoException(EventoException.MSG_EXCEPTION_DELETAR_EVENTO_COM_PARTICIPANTES);
        }
    }

    public Evento editarEvento(Long id, Evento evento) {
        if (eventoRepository.findById(id).get() == null)
            return null;
        evento.setId(id);
        return eventoRepository.save(evento);
    }

}
