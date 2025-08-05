package com.example.aluno.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "data_inclusao", nullable = false, updatable = false)
    private LocalDate dataInclusao;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDate dataAtualizacao;

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }
}
