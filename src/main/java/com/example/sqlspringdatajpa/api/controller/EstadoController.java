package com.example.sqlspringdatajpa.api.controller;

import com.example.sqlspringdatajpa.domain.exception.EntidadeEmUsoException;
import com.example.sqlspringdatajpa.domain.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private com.example.sqlspringdatajpa.domain.exception.repository.EstadoRepository estadoRepository;

    @Autowired
    private com.example.sqlspringdatajpa.domain.exception.service.EstadoService estadoService;

    @GetMapping
    public List<com.example.sqlspringdatajpa.domain.exception.model.Estado> listar() {
        return estadoRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    public ResponseEntity<com.example.sqlspringdatajpa.domain.exception.model.Estado> buscar(@PathVariable Long estadoId) {
        Optional<com.example.sqlspringdatajpa.domain.exception.model.Estado> estado = estadoRepository.findById(estadoId);

        if (estado.isPresent()) {
            return ResponseEntity.ok(estado.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public com.example.sqlspringdatajpa.domain.exception.model.Estado adicionar(@RequestBody com.example.sqlspringdatajpa.domain.exception.model.Estado estado) {
        return estadoService.salvar(estado);
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<com.example.sqlspringdatajpa.domain.exception.model.Estado> atualizar(@PathVariable Long estadoId,
                                                                                                @RequestBody com.example.sqlspringdatajpa.domain.exception.model.Estado estado) {
        com.example.sqlspringdatajpa.domain.exception.model.Estado estadoAtual = estadoRepository.findById(estadoId).orElse(null);

        if (estadoAtual != null) {
            BeanUtils.copyProperties(estado, estadoAtual, "id");

            estadoAtual = estadoService.salvar(estadoAtual);
            return ResponseEntity.ok(estadoAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<?> remover(@PathVariable Long estadoId) {
        try {
            estadoService.excluir(estadoId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

}