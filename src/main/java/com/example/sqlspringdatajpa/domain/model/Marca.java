package com.example.sqlspringdatajpa.domain.exception.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Marca {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

     @Column(nullable = false)
     private String descrição;
}
