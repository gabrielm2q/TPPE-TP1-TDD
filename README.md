# Técnicas de Programação em Plataformas Emergentes

## Trabalho 01

### Integrantes

| Matrícula | Nome |
| :--- | :--- |
| 20/0014447 | André Corrêa da Silva |
| 22/2015103 | Débora Caires de Souza Moreira |
| 20/0018167 | Gabriel Mariano da Silva |
| 19/0058455 | Mariana Oliveira Pires do Rio |

### Tecnologias Utilizadas

- **Java**: Utilizado como a linguagem principal de desenvolvimento do projeto.
- **JUnit 4**: Framework de testes usado para implementar o Desenvolvimento Orientado a Testes (TDD).
- **Git**: Sistema de controle de versão para rastreamento de mudanças no código.
- **IDE (Eclipse)**: Ambiente de desenvolvimento integrado para facilitar a codificação e testes.

### Objetivos

&nbsp;&nbsp;&nbsp;&nbsp;O objetivo deste trabalho é desenvolver um sistema de cadastro e gerenciamento de clientes e produtos utilizando técnicas de Desenvolvimento Orientado a Testes (TDD) com Java e JUnit 4. O sistema permitirá cadastrar clientes de diferentes categorias (padrão, especial e prime) com seus respectivos endereços, além de produtos com suas especificações detalhadas. Será possível realizar vendas, onde o sistema calculará automaticamente fretes, descontos, impostos e permitirá o uso de saldo de cashback para clientes prime. 

&nbsp;&nbsp;&nbsp;&nbsp;Adicionalmente, o sistema avaliará o volume de vendas mensais de cada cliente para determinar elegibilidade para upgrades de categoria. A implementação será acompanhada de uma suíte de testes para garantir a qualidade e funcionalidade do software, assegurando que cada funcionalidade atenda aos requisitos definidos.

### Requisitos
#### Funcionais:
- Cadastro de Clientes:
    - Implementar classes para os três tipos de clientes: padrão, especial e prime.
    - Cada cliente deve ter atributos como nome, tipo de cliente, e endereço (estado e se é capital ou interior).
- Cadastro de Produtos:
    - Implementar uma classe para representar diferentes tipos de produtos.
    - Cada produto deve ter atributos como código do item, descrição, valor de venda e unidade de medida (por exemplo, peça, unidade, metro, cm³).
- Realização de Vendas:
    - Implementar uma classe Venda que registre a data da venda, cliente, lista de itens vendidos e método de pagamento.
    - Calcular o valor do frete, descontos (se houver), impostos (ICMS e municipal).
    - Clientes prime podem usar saldo de cashback para abater na compra.
- Cálculo de Vendas do Último Mês:
    - Implementar métodos para calcular o valor das vendas realizadas no último mês para cada cliente.
    - Verificar se um cliente é elegível para se tornar cliente especial com base em critérios específicos (por exemplo, total de compras).
- Cálculo de Cashback para Clientes Prime:
    - Implementar o cálculo do saldo de cashback acumulado por clientes prime, baseado em percentuais das compras realizadas.
#### Não Funcionais:
- TDD (Test-Driven Development):
    - Desenvolver cada funcionalidade utilizando TDD, onde testes unitários são escritos antes da implementação do código.
    - Cada classe e método deve ter pelo menos um caso de teste.
    - Agrupar casos de testes relacionados em suites de testes quando apropriado.
- Java e JUnit 4:
    - O projeto deve ser desenvolvido em Java utilizando o JUnit 4 como framework de testes.
    - Outras linguagens e frameworks não são permitidos e resultarão em zero na avaliação.
