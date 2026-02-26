# 🎬 Movieflix API

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?logo=swagger&logoColor=black)

## 📖 Sobre o Projeto

O **MovieFlix API** é uma aplicação backend desenvolvida com foco em boas práticas de arquitetura REST, utilizando **Spring Boot**, **PostgreSQL** e **Docker**.

O projeto foi criado com o objetivo de:

- 🎯 Praticar construção de APIs RESTful
- 🧱 Aplicar arquitetura em camadas (Controller, Service, Repository)
- 🗄️ Integrar banco de dados relacional com JPA/Hibernate
- 📦 Containerizar a aplicação com Docker
- 📑 Documentar endpoints utilizando Swagger
- 🚀 Simular um ambiente próximo ao mercado de trabalho
---

## 🚀 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* PostgreSQL
* Flyway
* Maven
* Swagger / OpenAPI (springdoc)

---

## 📚 Funcionalidades

### 🔐 Autenticação

* Registro de usuário
* Login com geração de token JWT

### 🎥 Filmes

* Cadastrar filme
* Listar filmes
* Buscar por ID
* Atualizar filme
* Deletar filme
* Buscar filmes por categoria

### 📺 Streaming

* Cadastrar serviço
* Listar serviços
* Buscar por ID
* Deletar serviço

### 🗂️ Categorias

* Cadastrar categoria
* Listar categorias
* Buscar por ID
* Deletar categoria

---

# 📖 Documentação da API

Após iniciar o projeto, acesse:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 🛠️ Como rodar o projeto
Este projeto utiliza o **Docker** para gerenciar o Banco de Dados, enquanto a aplicação Java roda localmente para facilitar o desenvolvimento.

## Pré-requisitos
- Java 17 (JDK) e Maven instalados.
- Docker e Docker Compose instalados.
- Uma IDE (IntelliJ ou Eclipse) ou Terminal.


## 1️⃣ Clonar repositório

```bash
git clone https://github.com/NvMeireles/Movieflix.git
cd Movieflix
```

---

## 2️⃣ Subir aplicação com Docker

```bash
docker compose up -d --build
```

---

## 3️⃣ Rodar aplicação

Com o banco rodando, inicie a aplicação Spring Boot:

**Via Terminal:**

```bash
# Linux / Mac
./mvnw spring-boot:run

# Windows
.\mvnw.cmd spring-boot:run
```

A API estará disponivel em:

```código
http://localhost:8080
```


---

# 🔐 Autenticação

## Registrar usuário

```http
POST /movieflix/auth/register
```

Exemplo de body:

```json
{
  "name": "Nicolas",
  "email": "nicolas@email.com",
  "password": "123456"
}
```

---

## Login

```http
POST /movieflix/auth/login
```

Body:

```json
{
  "email": "nicolas@email.com",
  "password": "123456"
}
```

Resposta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

Use o token no Swagger clicando em **Authorize**:

```text
Bearer SEU_TOKEN_AQUI
```

---

# 🎥 Endpoints de Filme

## Listar todos

```http
GET /movieflix/movie
```

## Buscar por ID

```http
GET /movieflix/movie/{id}
```

## Cadastrar

```http
POST /movieflix/movie
```

Exemplo:

```json
{
  "title": "Interestelar",
  "description": "Filme de ficção científica",
  "releaseDate": "07/11/2014",
  "rating": 9.5,
  "categories": [1, 2],
  "streamings": [1]
}
```

## Atualizar

```http
PUT /movieflix/movie/{id}
```

## Deletar

```http
DELETE /movieflix/movie/{id}
```

## Buscar por categoria

```http
GET /movieflix/movie/search?category=1
```

---

# 📺 Endpoints de Streaming

```http
GET    /movieflix/streaming
POST   /movieflix/streaming
GET    /movieflix/streaming/{id}
DELETE /movieflix/streaming/{id}
```

Exemplo POST:

```json
{
  "name": "Netflix"
}
```

---

# 🗂️ Endpoints de Categoria

```http
GET    /movieflix/category
POST   /movieflix/category
GET    /movieflix/category/{id}
DELETE /movieflix/category/{id}
```

Exemplo POST:

```json
{
  "name": "Ação"
}
```

---

# 🏗️ Arquitetura

O projeto segue arquitetura em camadas:

```text
controller → service → repository → entity
```

Também utiliza:

* DTO (Request/Response)
* Mapper
* Security com JWT
* Documentação via interface
* Tratamento de exceções customizadas

---

# 🏆 Autor
Desenvolvido por **Nicolas Meireles** 🚀

<br>

<a href="https://www.linkedin.com/in/nicolasmeireles/" target="_blank">
  <img src="https://img.shields.io/badge/LinkedIn-Connect-0A66C2?logo=linkedin&logoColor=white"/>
</a>
<a href="https://github.com/NvMeireles" target="_blank">
  <img src="https://img.shields.io/badge/GitHub-Profile-181717?logo=github&logoColor=white"/>
</a>

</div>

