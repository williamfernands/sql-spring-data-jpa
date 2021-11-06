package com.example.sqlspringdatajpa.domain.exception.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

}
