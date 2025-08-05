package com.example.aluno.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "aluno_id")
public class Aluno extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "tb_matricula")
    private List<Matricula> matriculas = new ArrayList<>();






}



