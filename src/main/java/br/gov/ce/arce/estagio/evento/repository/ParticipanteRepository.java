package br.gov.ce.arce.estagio.evento.repository;

import br.gov.ce.arce.estagio.evento.model.Participante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteRepository extends CrudRepository<Participante, Long> {
    List<Participante> findByEventoId(Long id);
}
