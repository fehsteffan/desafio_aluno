package com.example.aluno.dto;

import java.time.LocalDate;

public record MatriculaDto(

        String codigoMatricula,
        String nomeCurso,
        LocalDate dataInicio) {
}
