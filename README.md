
# MyFinance Web

<p align="center">
  <b>Pontifícia Universidade Católica de Minas Gerais</b><br>
  <b>Curso de Pós-Graduação em Engenharia de Software</b><br>
  Disciplina: Práticas de Implementação e Evolução de Software<br>
  Prof.: Filipe Tório
</p>

---

##  Responsáveis
    
* Fernanda Rosa de Oliveira
* Fernanda Ferreira e Silva do Nascimento


---

##  **Descrição do Projeto**

O **MyFinance Web** é uma aplicação desenvolvida com o objetivo de ajudar famílias a **registrarem suas receitas e despesas**, permitindo uma visão clara sobre seu orçamento e um melhor planejamento financeiro.

Conforme pesquisa do Estadão (ROCHA, 2022), **52% dos brasileiros não possuem ou não sabem como montar um planejamento financeiro para os próximos anos**, sendo esse um problema relevante e recorrente.

---

##  **Problema**

> “A pesquisa ouviu 3.450 pessoas de diversas regiões do país durante os meses de novembro e dezembro de 2021. De acordo com o estudo, 52% dos entrevistados não possuem ou não sabem como montar um planejamento financeiro para os próximos anos. Além disso, 46% disseram que não se sentem confiantes para estabelecer metas de longo prazo.”
>
> Referência: [Estadão E-Investidor](https://einvestidor.estadao.com.br/educacao-financeira/brasileiros-planejamento-financeiro-pesquisa) (ROCHA, Daniel. 19 jan. 2022)

---

##  **Proposta**

Criar uma aplicação web para que famílias possam **registrar receitas e despesas**, categorizá-las em **Planos de Conta**, e realizar análises financeiras através de relatórios e gráficos, melhorando seu planejamento.

---

##  **Requisitos Funcionais**

### ✅ **RF001 – Plano de Contas**

- Cadastro de **Plano de Contas** para categorização de Receitas e Despesas.
- Exemplo:

| Código | Descrição              | Tipo    |
|--------|------------------------|---------|
| 1      | Combustível            | Despesa |
| 2      | Supermercado           | Despesa |
| 3      | Almoço                 | Despesa |
| 4      | IPTU                   | Despesa |
| 5      | IPVA                   | Despesa |
| 6      | Salário                | Receita |
| 7      | Crédito de Juros       | Receita |
| 8      | Apartamento de Aluguel | Receita |

---

### ✅ **RF002 – Registro de Transações**

- Registro de **Transações Financeiras** vinculadas a um Plano de Conta.

| Código | Histórico        | Data                 | Plano de Conta | Valor     |
|--------|------------------|----------------------|----------------|-----------|
| 100    | Gasolina Viagem  | 20/12/2022 – 14:00   | Combustível    | R$ 289,00|
| 200    | Almoço Família   | 24/12/2022 – 12:30   | Almoço         | R$ 120,00|
| 300    | Salário          | 05/01/2023 – 00:00   | Salário        | R$ 1.000,00|
| 400    | IPVA Blazer      | 10/01/2023 – 13:30   | IPVA           | R$ 250,00|

---

### ✅ **RF003 – Relatório de Transações por Período**

- Relatório em **HTML** demonstrando transações por tipo (**Receita** ou **Despesa**) e filtradas por período de datas.

---

### ✅ **RF004 – Gráfico de Receitas vs Despesas por Período**

- Gráfico do tipo **pizza** mostrando o total de receitas e despesas no período filtrado.

---

##  **Requisitos Não Funcionais**

### ✅ **RNF005 – Suporte a Plataformas**

- Desenvolvido como **aplicação web responsiva**, adaptada a telas de smartphones e tablets utilizando Bootstrap 5.

###  **RNF006 – Linguagens de Implementação**

> **Nota:** A especificação previa ASP.NET MVC com SQL Server, mas foi utilizado **Java Spring Boot + PostgreSQL** para a execução deste projeto acadêmico.

---

## ️ **Arquitetura Utilizada**

- **Backend:** Spring Boot MVC
- **View Engine:** Thymeleaf
- **Persistência:** Spring Data JPA
- **Banco de Dados:** PostgreSQL (via Docker)
- **Frontend:** Bootstrap 5 (CDN)

## ️ **Estrutura**
com.br.project.myfinance
├── controllers
├── model
│ ├── entity
│ └── service
└── repository


---

##  **Como Executar o Projeto**

### **Pré-requisitos**

- Java 21
- Docker
- PostgreSQL (via Docker)
- IDE (IntelliJ, Eclipse ou VSCode)

---

## Passo a Passo

1. **Clone o repositório**

```bash
git clone https://github.com/seuusuario/myfinance.git
cd myfinance
```

2. **Suba o banco de dados PostgreSQL via Docker**
```bash
docker run --name postgres-myfinance -e POSTGRES_PASSWORD=senhaForte123 -e POSTGRES_USER=postgre_user -e POSTGRES_DB=myFinanceDatabase -p 5432:5432 -d postgres
```

2. **Suba o banco de dados PostgreSQL via Docker**
```bash
docker run --name postgres-myfinance -e POSTGRES_PASSWORD=suasenha -p 5432:5432 -d postgres
```

3. **Crie o banco e depois execute os scripts em Scripts-DB.sql**

```bash
CREATE DATABASE myFinanceDatabase;
```

4. **Execute a aplicação no Intellij ou VisualStudioCode, rodando a classe principal**

```bash
MyFinanceApplication.java
```


4. **Após o start da aplicação, acesse**

```bash
http://localhost:8080
```

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.0
- Thymeleaf
- Bootstrap 5.3.3
- PostgreSQL 15
- Maven
- Lombok

## Funcionalidades Implementadas

✔️ Cadastro de Planos de Conta
✔️ Registro de Transações (Receitas e Despesas)
✔️ Edição de Transações
✔️ Relatório de Transações por Período
✔️ Gráfico de pizza Receitas vs Despesas
✔️ Layout responsivo (Bootstrap 5)

## Melhorias Futuras

- Implementação de login e autenticação (Spring Security)
- Exportação de relatórios em PDF
- Deploy em ambiente cloud (AWS ou GCP)

