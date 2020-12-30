package br.gov.ce.arce.estagio.evento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;

    @CreatedBy
    @JsonIgnore
    @NotNull
    @Column(name="created_by")
    private String createdBy;

    @CreatedDate
    @JsonIgnore
    @NotNull
    @Column(name="created_date")
    private LocalDateTime createdDate;

    @LastModifiedBy
    @JsonIgnore
    @NotNull
    @Column(name="last_modified_by")
    private String lastModifiedBy;

    @LastModifiedDate
    @JsonIgnore
    @NotNull
    @Column(name="last_modified_date")
    private LocalDateTime lastModifiedDate;

}
