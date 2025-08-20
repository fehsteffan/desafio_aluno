package com.example.aluno.service;

import com.example.aluno.dto.AlunoDto;
import com.example.aluno.dto.AlunoResponse;
import com.example.aluno.dto.MatriculaDto;
import com.example.aluno.entity.Aluno;
import com.example.aluno.entity.Matricula;
import com.example.aluno.mapper.AlunoMapper;
import com.example.aluno.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@Service
public class AlunoService {


    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

        public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper){
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public List<AlunoResponse> listarTodos() {
            return alunoRepository.findAll().stream().map(alunoMapper::toResponse).toList();
            
    }

    public AlunoResponse salvar(AlunoDto dto) {
            Aluno aluno = alunoMapper.toEntity(dto);
            alunoRepository.save(aluno);
            return alunoMapper.toResponse(aluno);
    }

    public List<MatriculaDto> listarMatriculas(Long id) {
           Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluno nao encontrado"));
            return aluno.getMatriculas().stream().map(m -> new MatriculaDto(m.getCodigoMatricula(), m.getNomeCurso(), m.getDataInicio())).toList();
    }


    public void remover(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("ID do aluno nao encontrado");

        }
        alunoRepository.deleteById(id);

          }


          public AlunoResponse atualizar(Long id, AlunoDto dto) {
            Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluno nao encontrado"));
            aluno.setNome(dto.nome());
            aluno.setTelefone(dto.telefone());
            aluno.setDataNascimento(dto.dataNascimento());

            for (MatriculaDto m : dto.matriculas()){
                Matricula matricula = new Matricula();
                matricula.setCodigoMatricula(m.codigoMatricula());
                matricula.setDataInicio(m.dataInicio());
                matricula.setNomeCurso(m.nomeCurso());
                aluno.getMatriculas().add(matricula);
            }

            return alunoMapper.toResponse(alunoRepository.save(aluno));

          }


}