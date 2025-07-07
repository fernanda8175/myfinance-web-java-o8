DROP TABLE IF EXISTS mf_plano_conta;
DROP TABLE IF EXISTS mf_transacao;

CREATE TABLE mf_plano_conta (
    codigo BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    tipo_movimentacao INTEGER NOT NULL
);

CREATE TABLE mf_transacao (
    codigo BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    historico VARCHAR(255) NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    plano_conta_codigo BIGINT NOT NULL,
    CONSTRAINT fk_plano_conta
        FOREIGN KEY (plano_conta_codigo)
        REFERENCES mf_plano_conta(codigo)
);


INSERT INTO mf_plano_conta (descricao, tipo_movimentacao) VALUES
('Salário', 1),
('Freelance', 1),
('Investimentos', 1),
('Aluguel', 0),
('Energia elétrica', 0),
('Água', 0),
('Internet', 0),
('Supermercado', 0),
('Transporte', 0),
('Lazer', 0),
('Educação', 0),
('Consultoria PJ', 1),
('Mensalidade da academia', 0),
('Manutenção do carro', 0),
('Lucro de vendas', 1);