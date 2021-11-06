package com.example.sqlspringdatajpa.domain.exception.service;

import com.example.sqlspringdatajpa.domain.exception.model.Pessoa;
import com.example.sqlspringdatajpa.domain.exception.EntidadeEmUsoException;
import com.example.sqlspringdatajpa.domain.exception.EntidadeNaoEncontradaException;
import com.example.sqlspringdatajpa.domain.exception.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void excluir(String pessoaId) {
        try {
            pessoaRepository.deleteById(pessoaId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de pessoa com código %d", pessoaId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Pessoa de código %d não pode ser removido, pois está em uso", pessoaId));
        }
    }
}