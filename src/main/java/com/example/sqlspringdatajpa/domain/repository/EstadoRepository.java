package com.example.sqlspringdatajpa.domain.exception.repository;

import com.example.sqlspringdatajpa.domain.exception.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
