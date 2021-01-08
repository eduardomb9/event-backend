package br.gov.ce.arce.estagio.evento.specification;

import br.gov.ce.arce.estagio.evento.model.Participant;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class ParticipantSpecification {
    public static Specification<Participant> eventoId(Long id) {
        return (root, criteriaQuery, criteriaBuilder) -> Objects.nonNull(id) ? criteriaBuilder.equal(root.join("event").get("id"), id) : null;
    }
}
