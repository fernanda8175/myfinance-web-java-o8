package com.br.project.myfinance.model.domain;

import com.br.project.myfinance.model.entity.TipoMovimentacao;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "mf_plano_conta")
public class PlanoConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_movimentacao", nullable = false)
    private TipoMovimentacao tipoMovimentacao;

}