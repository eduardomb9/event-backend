package br.gov.ce.arce.estagio.evento.service;

import br.gov.ce.arce.estagio.evento.model.EventType;
import br.gov.ce.arce.estagio.evento.repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventTypeService {

    @Autowired
    private EventTypeRepository repository;

    public List<EventType> getTiposEventos() {
        List<EventType> tipos = new ArrayList<>();
        for (EventType t : repository.findAll()) {
            tipos.add(t);
        }
        return tipos;
    }

}
