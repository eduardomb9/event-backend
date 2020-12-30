package br.gov.ce.arce.estagio.evento.repository;

import br.gov.ce.arce.estagio.evento.model.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Long> {
    List<Participant> findByEventoId(Long id);
}
