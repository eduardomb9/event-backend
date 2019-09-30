package br.gov.ce.arce.estagio.evento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(schema = "estagiario")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_participante_sq")
    @SequenceGenerator(name = "id_participante_sq", sequenceName = "estagiario.id_participante_sq", allocationSize = 1, initialValue = 100)
    private Long id;

    @NotBlank(message = "Digite um nome.")
    private String nome;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
