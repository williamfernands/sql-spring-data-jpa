package com.example.sqlspringdatajpa.domain.exception.service;

import com.example.sqlspringdatajpa.domain.exception.model.Estado;
import com.example.sqlspringdatajpa.domain.exception.EntidadeEmUsoException;
import com.example.sqlspringdatajpa.domain.exception.EntidadeNaoEncontradaException;
import com.example.sqlspringdatajpa.domain.exception.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

      @Autowired
      private EstadoRepository estadoRepository;

      public Estado salvar(Estado estado) {
          return estadoRepository.save(estado);
      }
      public void excluir(Long estadoId) {
         try {
               estadoRepository.deleteById(estadoId);

         } catch (EmptyResultDataAccessException e) {
               throw new EntidadeNaoEncontradaException(
               String.format("Não existe um cadastro de estado com código %d", estadoId));

         } catch (DataIntegrityViolationException e) {
               throw new EntidadeEmUsoException(
               String.format("Estado de código %d não pode ser removido, pois está em uso", estadoId));
         }
      }
}
