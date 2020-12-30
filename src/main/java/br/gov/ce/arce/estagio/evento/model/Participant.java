package br.gov.ce.arce.estagio.evento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(schema = "estagiario")
public class Participant extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_participante_sq")
    @SequenceGenerator(name = "id_participante_sq", sequenceName = "estagiario.id_participante_sq", allocationSize = 1, initialValue = 100)
    private Long id;

    @NotBlank(message = "participant.name.required")
    private String nome;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event event;

}
