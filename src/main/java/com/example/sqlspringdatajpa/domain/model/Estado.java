package com.example.sqlspringdatajpa.domain.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Data
public class Estado {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false)
     private String estado;

}
