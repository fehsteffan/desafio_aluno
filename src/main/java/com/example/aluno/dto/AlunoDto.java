package com.example.aluno.dto;

import java.time.LocalDate;
import java.util.List;


public record AlunoDto(

        String nome,
        String telefone,
        LocalDate dataNascimento,
        List<MatriculaDto> matriculas) {
}
