package br.gov.ce.arce.estagio.evento.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_evento", schema = "estagiario")
public class TipoEvento {

    @Id
    @SequenceGenerator(name = "sq_tipo_evento", sequenceName = "estagiario.sq_tipo_evento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tipo_evento")
    @Column(name = "id_tipo_evento")
    private Integer id;

    @Column(name = "nm_tipo_evento")
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
