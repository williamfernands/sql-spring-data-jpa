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
    @RequestMapping("/pessoas")
    public class PessoaController {

        @Autowired
        private com.example.sqlspringdatajpa.domain.exception.repository.PessoaRepository pessoaRepository;

        @Autowired
        private com.example.sqlspringdatajpa.domain.exception.service.PessoaService pessoaService;

        @GetMapping
        public List<com.example.sqlspringdatajpa.domain.exception.model.Pessoa> listar() {
            return pessoaRepository.findAll();
        }

        @GetMapping("/{estadoId}")
        public ResponseEntity<com.example.sqlspringdatajpa.domain.exception.model.Pessoa> buscar(@PathVariable String pessoaId) {
            Optional<com.example.sqlspringdatajpa.domain.exception.model.Pessoa> pessoa = pessoaRepository.findById(pessoaId);

            if (pessoa.isPresent()) {
                return ResponseEntity.ok(pessoa.get());
            }

            return ResponseEntity.notFound().build();
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public com.example.sqlspringdatajpa.domain.exception.model.Pessoa adicionar(@RequestBody com.example.sqlspringdatajpa.domain.exception.model.Pessoa pessoa) {
            return pessoaService.salvar(pessoa);
        }

        @PutMapping("/{estadoId}")
        public ResponseEntity<com.example.sqlspringdatajpa.domain.exception.model.Pessoa> atualizar(@PathVariable String estadoId,
                                                                                                    @RequestBody com.example.sqlspringdatajpa.domain.exception.model.Estado estado) {
            com.example.sqlspringdatajpa.domain.exception.model.Pessoa pessoaAtual = pessoaRepository.findById(estadoId).orElse(null);

            if (pessoaAtual != null) {
                BeanUtils.copyProperties(estado, pessoaAtual, "id");

                pessoaAtual = pessoaService.salvar(pessoaAtual);
                return ResponseEntity.ok(pessoaAtual);
            }

            return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{estadoId}")
        public ResponseEntity<?> remover(@PathVariable String estadoId) {
            try {
                pessoaService.excluir(estadoId);
                return ResponseEntity.noContent().build();

            } catch (EntidadeNaoEncontradaException e) {
                return ResponseEntity.notFound().build();

            } catch (EntidadeEmUsoException e) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(e.getMessage());
            }
        }
    }

