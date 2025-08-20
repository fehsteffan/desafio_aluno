package com.example.aluno.controller;

import com.example.aluno.dto.AlunoDto;
import com.example.aluno.dto.AlunoResponse;
import com.example.aluno.dto.MatriculaDto;
import com.example.aluno.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;

    }

    @PostMapping
    public ResponseEntity<AlunoResponse> criar(@RequestBody AlunoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(dto));

    }


    @GetMapping
    public List<AlunoResponse> listarTodos() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}/matriculas")
    public List<MatriculaDto> listarMatriculas(@PathVariable Long id) {
        return alunoService.listarMatriculas(id);
    }

    @PutMapping
    public ResponseEntity<AlunoResponse> atualizar(@PathVariable Long id, @RequestBody AlunoDto dto) {
        return ResponseEntity.ok(alunoService.atualizar(id, dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        alunoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
