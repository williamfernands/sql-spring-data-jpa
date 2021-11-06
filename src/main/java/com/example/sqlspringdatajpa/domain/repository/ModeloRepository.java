package com.example.sqlspringdatajpa.domain.exception.repository;

import com.example.sqlspringdatajpa.domain.exception.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
