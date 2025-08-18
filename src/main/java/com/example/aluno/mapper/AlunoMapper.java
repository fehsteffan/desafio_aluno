package com.example.aluno.mapper;

import com.example.aluno.dto.AlunoDto;
import com.example.aluno.dto.AlunoResponse;
import com.example.aluno.dto.MatriculaDto;
import com.example.aluno.entity.Aluno;
import com.example.aluno.entity.Matricula;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AlunoMapper {

    public Aluno toEntity(AlunoDto dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setTelefone(dto.telefone());
        aluno.setDataNascimento(dto.dataNascimento());
        List<Matricula> matriculas = dto.matriculas().stream().map(m-> {

            Matricula matricula = new Matricula();
            matricula.setCodigoMatricula(m.codigoMatricula());
            matricula.setDataInicio(m.dataInicio());
            matricula.setNomeCurso(m.nomeCurso());
            return matricula;

        }).toList();

        return aluno;

    }

    public AlunoResponse toResponse(Aluno aluno) {
        List<MatriculaDto> matriculaDtos = aluno.getMatriculas().stream().map(m->
                new MatriculaDto(m.getCodigoMatricula(), m.getNomeCurso(),m.getDataInicio())).toList();
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getTelefone(), aluno.getDataNascimento(), matriculaDtos);


    }

}
