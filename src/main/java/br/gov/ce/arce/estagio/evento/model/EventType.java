package br.gov.ce.arce.estagio.evento.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_tipo_evento", schema = "estagiario")
public class EventType extends AbstractEntity<Integer> implements Serializable {

    @Id
    @SequenceGenerator(name = "sq_tipo_evento", sequenceName = "estagiario.sq_tipo_evento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tipo_evento")
    @Column(name = "id_tipo_evento")
    private Integer id;

    @Column(name = "nm_tipo_evento")
    private String descricao;

}
