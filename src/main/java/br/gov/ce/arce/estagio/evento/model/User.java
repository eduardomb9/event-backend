package br.gov.ce.arce.estagio.evento.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "estagiario", name = "tb_usuario")
public class User extends AbstractEntity<Long> {
}
