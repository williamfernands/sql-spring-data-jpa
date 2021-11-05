package com.example.sqlspringdatajpa.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String descrição;
}
