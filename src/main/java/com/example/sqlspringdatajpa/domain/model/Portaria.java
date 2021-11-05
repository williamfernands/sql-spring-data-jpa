package com.example.sqlspringdatajpa.domain.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Portaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_cpf", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @Column(name = "datahora_entrada")
    private LocalDateTime dataHoraEntrada;

    @Column(name = "datahora_saida")
    private LocalDateTime dataHoraSaida;

    @CreationTimestamp
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

}
