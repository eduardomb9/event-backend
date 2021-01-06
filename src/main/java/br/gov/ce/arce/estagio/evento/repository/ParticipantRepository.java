package br.gov.ce.arce.estagio.evento.repository;

import br.gov.ce.arce.estagio.evento.model.Participant;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Long>, JpaSpecificationExecutor<Participant> {
}
