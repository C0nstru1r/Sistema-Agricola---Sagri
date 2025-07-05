# Sagri 2.0 - Backend

Este projeto é a implementação backend do sistema "Sagri 2.0", que é um sistema de controle de estoque para o setor agrícola. Ele foi desenvolvido usando o framework Spring Boot e utiliza o banco de dados PostgreSQL.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.1.3
- PostgreSQL (Banco de dados)
- Maven (Gerenciador de dependências)
- Thymeleaf (Motor de templates para front-end)
- Spring Data JPA (Para manipulação de dados no banco)

## Estrutura do Projeto
- **src/main/java/com/sagri/estoque**: Contém a lógica do backend, incluindo controladores (controllers), serviços (services) e modelos (models).
- **src/main/resources**: Contém arquivos de configuração do Spring Boot e templates do Thymeleaf.
- **src/main/resources/application.properties**: Configurações do banco de dados e do servidor.
- **pom.xml**: Gerenciador de dependências e configuração do Maven.
- **mvnw e mvnw.cmd**: Scripts para rodar o Maven sem precisar de instalação global do Maven.

## Como Rodar o Projeto

### Requisitos
- Java 17 ou superior
- PostgreSQL

### Passos

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/C0nstru1r/Sagri-2.0.git
   cd Sagri-2.0/backend