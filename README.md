<h1 align="center">🟢 Gestão de Resíduos</h1>

<p align="center">
  API REST para cadastro e monitoramento de pontos de coleta e materiais recicláveis, desenvolvida com Spring Boot e Java.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Status-Concluído-brightgreen" alt="status" />
  <img src="https://img.shields.io/badge/Java-17-blue?logo=java" alt="java" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen?logo=springboot" alt="spring boot" />
</p>

---

## 🌱 Sobre o projeto

Esta API foi desenvolvida como parte de um projeto acadêmico com o objetivo de auxiliar na **gestão de resíduos recicláveis**.

A aplicação permite:

* Cadastrar e listar **pontos de coleta**
* Cadastrar e consultar **resíduos recicláveis**
* Registrar **coletas**, com status como *pendente*, *em andamento* ou *concluída*
* Realizar buscas por entidades
* Aplicar boas práticas RESTful com estrutura MVC e DTOs

---

## 📁 Estrutura do Projeto

```
gestao-residuos
├── controller/         # Camada de controle (endpoints REST)
├── service/            # Regras de negócio
├── model/              # Entidades JPA
├── repository/         # Interfaces JPA
├── dto/                # Data Transfer Objects
├── enums/              # Enums de domínio
├── config/             # Configurações de segurança
├── advice/             # Tratamento de exceções
└── resources/          # application.properties + Flyway (migrações)
```

---

## 🚀 Tecnologias utilizadas

* Java 17 ☕
* Spring Boot 3
* Spring Data JPA
* Maven
* Flyway (versões de banco)
* H2 (banco em memória para testes locais)
* Postman (para testar endpoints REST)

---

## ⚙️ Como executar

### Pré-requisitos

* Java 17+
* Maven

### Passo a passo

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/gestao-residuos.git

# Acesse a pasta
cd gestao-residuos

# Compile o projeto
mvn clean install

# Rode a aplicação
mvn spring-boot:run
```

Acesse os endpoints pela porta padrão:

```
http://localhost:8080
```

---

## 🧪 Endpoints principais

| Método | Rota          | Função                    |
| ------ | ------------- | ------------------------- |
| GET    | /ponto-coleta | Listar pontos de coleta   |
| POST   | /ponto-coleta | Cadastrar ponto de coleta |
| GET    | /reciclavel   | Listar recicláveis        |
| POST   | /reciclavel   | Cadastrar reciclável      |

---

## 🔐 Segurança

A segurança está configurada via `SecurityConfig.java`, com regras básicas para exposição pública de endpoints.

---


## 🔧 Status do Projeto

✅ Concluído para fins acadêmicos

---

## 👩‍💼 Autoria

Desenvolvido por **Geovanna Dias** 💚
[LinkedIn](https://linkedin.com/in/geosdias) • [GitHub](https://github.com/Geotryy) • [geovannasdias@hotmail.com](mailto:geovannasdias@hotmail.com)

---

<p align="center"><i>“Desenvolver com propósito é transformar ideias em impacto.”</i></p>
