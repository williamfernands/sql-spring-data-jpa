package com.example.sqlspringdatajpa.domain.exception.repository;

import com.example.sqlspringdatajpa.domain.exception.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String>{

}
