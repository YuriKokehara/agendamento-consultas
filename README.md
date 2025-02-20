# Sistema de Agendamento de Consultas

Este projeto é um sistema de agendamento de consultas desenvolvido em **Java** com **Spring Boot**. Ele permite o cadastro de médicos, pacientes e agendamento de consultas, seguindo regras de negócio para garantir a integridade dos dados.

---

## Funcionalidades

- **Cadastro de Médicos**:
  - Cadastro de médicos com nome e especialidade.
  - Validação de campos obrigatórios e tamanho máximo.

- **Cadastro de Pacientes**:
  - Cadastro de pacientes com nome, CPF e telefone.
  - Validação de campos obrigatórios e formato de CPF/telefone.

- **Agendamento de Consultas**:
  - Agendamento de consultas com médico, paciente, data/hora e observações.
  - Validação de horários disponíveis para médicos e pacientes.
  - Impedir agendamentos no passado.

- **Testes**:
  - Testes unitários para serviços.
  - Testes de integração para controllers.

---

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database** (banco de dados em memória para desenvolvimento)
- **Lombok** (para reduzir boilerplate code)
- **Mockito** (para testes unitários)
- **JUnit 5** (para testes)
- **Maven** (gerenciamento de dependências)

---

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **Java JDK 21**
- **Maven**
- **Git** (opcional, para clonar o repositório)

---

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/YuriKokehara/agendamento-consultas.git
2. Navegue até a pasta do projeto:
   ```bash
   cd backend-springboot
3. Compile e execute o projeto com Maven:
   ```bash
   mvn spring-boot:run
4. Acesse a API no endereço:
   ```
   http://localhost:8080
---

## Estrutura do Projeto
    src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── exemplo/
    │   │           └── agendamento/
    │   │               ├── controllers/       # Controllers da API
    │   │               ├── services/          # Lógica de negócio
    │   │               ├── repositorys/       # Repositórios JPA
    │   │               ├── entities/          # Entidades do banco de dados
    │   │               ├── dtos/              # Objetos de transferência de dados (DTOs)
    │   │               ├── exception/         # Tratamento de exceções
    │   │               └── AgendamentoApplication.java # Classe principal
    │   └── resources/
    │       ├── application.properties        # Configurações do projeto
    │       ├── application-test.properties   # Configurações do perfil de teste do projeto
    └── test/
        └── java/
            └── com/
                └── exemplo/
                    └── agendamento/
                        ├── services/          # Testes unitários
                        └── controllers/       # Testes de integração
---

## Testes

* Para executar todos os testes, use o comando:
   ```bash
   mvn test -Djdk.instrument.traceUsage=true
---

## Passos Futuros
- Adicionar autenticação e autorização com Spring Security.
- Substituir o H2 Database por um banco de dados real (MySQL/PostgreSQL).
- Implementar funcionalidades adicionais, como notificações e relatórios.
