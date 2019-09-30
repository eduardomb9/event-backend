package br.gov.ce.arce.estagio.evento.repository;

import br.gov.ce.arce.estagio.evento.model.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {
}
