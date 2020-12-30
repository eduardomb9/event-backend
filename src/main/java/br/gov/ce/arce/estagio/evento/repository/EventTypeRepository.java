package br.gov.ce.arce.estagio.evento.repository;

import br.gov.ce.arce.estagio.evento.model.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends CrudRepository<EventType, Long> {
}
