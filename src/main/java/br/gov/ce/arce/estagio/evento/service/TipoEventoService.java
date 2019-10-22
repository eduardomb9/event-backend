package br.gov.ce.arce.estagio.evento.service;

import br.gov.ce.arce.estagio.evento.model.TipoEvento;
import br.gov.ce.arce.estagio.evento.repository.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoEventoService {

    @Autowired
    private TipoEventoRepository repository;

    public List<TipoEvento> getTiposEventos() {
        List<TipoEvento> tipos = new ArrayList<>();
        for (TipoEvento t : repository.findAll()) {
            tipos.add(t);
        }
        return tipos;
    }

}
