package com.example.sqlspringdatajpa.repository;

import com.example.sqlspringdatajpa.domain.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository  extends JpaRepository<Marca, Long> {
}
