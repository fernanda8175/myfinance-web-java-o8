package com.br.project.myfinance.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "mf_transacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "historico", nullable = false)
    private String historico;

    @Column(name = "dataHora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "plano_conta_codigo")
    private PlanoConta planoConta;
}
