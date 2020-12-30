package br.gov.ce.arce.estagio.evento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(schema = "estagiario", name = "tb_evento")
public class Event extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_evento_sq")
    @SequenceGenerator(name = "id_evento_sq", sequenceName = "estagiario.id_evento_sq", allocationSize = 1)
    @Column(name = "id_evento")
    private Long id;

    @Column(name = "nm_evento")
    @NotEmpty(message = "event.name.required")
    private String nome;

    @Column(name = "dt_inicio")
    private LocalDateTime inicio;

    @Column(name = "dt_fim")
    private LocalDateTime fim;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @JsonIgnore
    @NotAudited
    @OneToMany(mappedBy = "evento")
    private List<Participant> participants = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_tipo_evento")
    private EventType eventType;

}
