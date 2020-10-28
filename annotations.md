# Considerações sobre o projeto

## Linguagem

A linguagem escolhida foi Java, por ser a que tenho mais familiaridade dentro das opções.
O projeto foi criado com Maven, para facilitar a criação de um ambiente de 
desenvolvimento compatível e gerenciamento de dependencias fácil.
O ambiente é compativel com Java 11.

## Framework

A escolha do uso do framework SpringBook foi pela sua proposta de convenção sobre 
configuração, abstraindo configurações e tornando o processo de desenvolvimento mais ágil, 
porém mantendo a liberdade sobre a arquitetura e configuração quando necessário.

## Aplicação

Foi criada uma api RESTful como designado, atendendo aos requisitos. No README é demonstrado
como executar a aplicação, assim como links para documentação da API.
Foi escolhido o banco de dados PostgreSql para persoistencia dos dados. A escolha foi feita por ele
além de ser um banco de dados open source, com disponibilidade gratuita em provedores, 
ACID (que para o intuito da API é necesário) e tem números de performance que se destacam.

## Testes

Devido ao pouco tempo livre que tive não consegui chegar a fazer testes de unidade, porém o ambiente
de teste, verificação e análise de resultados está configurado.