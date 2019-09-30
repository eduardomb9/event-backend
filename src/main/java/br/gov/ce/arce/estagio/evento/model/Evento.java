package br.gov.ce.arce.estagio.evento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "estagiario", name = "tb_evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_evento_sq")
    @SequenceGenerator(name = "id_evento_sq", sequenceName = "estagiario.id_evento_sq", allocationSize = 1)
    @Column(name = "id_evento")
    private Long id;

    @Column(name = "nm_evento")
    @NotEmpty(message = "Nome é um campo obrigatorio.")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "evento")
    private List<Participante> participantes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
