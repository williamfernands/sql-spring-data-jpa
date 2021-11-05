package com.example.sqlspringdatajpa.repository;

import com.example.sqlspringdatajpa.domain.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
