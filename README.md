Sistema de Cadastro com Autenticação e Autorização
Este projeto é uma aplicação Spring Boot que implementa um sistema de cadastro e autenticação de usuários, com funcionalidades de autorização baseadas em perfis (usuário comum e admin) e proteção de rotas utilizando Spring Security e JWT (JSON Web Tokens).

🚀 Tecnologias Utilizadas
Spring Boot: Framework para construção de aplicações Java robustas.

Spring Security: Framework poderoso para autenticação e autorização.

Spring Data JPA: Abstração para acesso a dados, facilitando a interação com bancos de dados relacionais.

PostgreSQL: Sistema de gerenciamento de banco de dados relacional.

JWT (JSON Web Tokens): Padrão para criação de tokens de acesso seguro.

BCrypt: Algoritmo de hash de senha para criptografia segura.

Lombok: Biblioteca que reduz a verborosidade do código Java.

✨ Funcionalidades
Registro de Usuários: Permite que novos usuários se cadastrem na aplicação.

Login e Geração de Token JWT: Usuários autenticados recebem um token JWT para acesso seguro às rotas protegidas.

Proteção de Rotas: Endpoints específicos são protegidos e exigem autenticação via JWT.

Autorização Baseada em Perfil: Diferenciação entre usuários com perfil USER e ADMIN, controlando o acesso a determinadas funcionalidades ou recursos.

Criptografia de Senhas: Utilização de BCrypt para armazenar senhas de forma segura no banco de dados.

⚙️ Pré-requisitos
Antes de rodar o projeto, certifique-se de ter instalado:

Java Development Kit (JDK) 17 ou superior

Maven

PostgreSQL: Um servidor PostgreSQL em execução.

🚀 Como Rodar o Projeto
Siga os passos abaixo para configurar e executar o projeto localmente:

Clone o repositório:

git clone <URL_DO_SEU_REPOSITORIO>
cd <NOME_DA_PASTA_DO_PROJETO>

Configuração do Banco de Dados PostgreSQL:

Crie um novo banco de dados no PostgreSQL (ex: auth_db).

Atualize o arquivo src/main/resources/application.properties com suas credenciais do PostgreSQL:

spring.datasource.url=jdbc:postgresql://localhost:5432/auth_db
spring.datasource.username=seu_usuario_postgres
spring.datasource.password=sua_senha_postgres
spring.jpa.hibernate.ddl-auto=update # Ou create, para criar as tabelas automaticamente
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

Construa o Projeto:

mvn clean install

Execute a Aplicação:

mvn spring-boot:run

A aplicação estará acessível em http://localhost:8080 por padrão.

🔑 Endpoints da API
Aqui estão os principais endpoints da API:

POST /auth/register: Registra um novo usuário.

Corpo da Requisição (JSON):

{
    "username": "novoUsuario",
    "password": "senhaSegura",
    "role": "USER" // ou "ADMIN"
}

POST /auth/login: Realiza o login e retorna um token JWT.

Corpo da Requisição (JSON):

{
    "username": "usuarioExistente",
    "password": "suaSenha"
}

Resposta (JSON):

{
    "token": "eyJhbGciOiJIUzI1NiIsIn..."
}

GET /api/public: Exemplo de rota pública (não requer autenticação).

GET /api/user: Exemplo de rota protegida para usuários com perfil USER ou ADMIN.

Cabeçalho Necessário: Authorization: Bearer SEU_TOKEN_JWT

GET /api/admin: Exemplo de rota protegida apenas para usuários com perfil ADMIN.

Cabeçalho Necessário: Authorization: Bearer SEU_TOKEN_JWT

🧪 Testando a Aplicação
Você pode usar ferramentas como Postman, Insomnia ou curl para testar os endpoints da API.

Registre um usuário.

Faça login com o usuário registrado para obter o token JWT.

Use o token JWT no cabeçalho Authorization: Bearer SEU_TOKEN para acessar as rotas protegidas.

Authentication System with Authorization
This project is a Spring Boot application that implements a user registration and authentication system, with authorization functionalities based on profiles (common user and admin) and route protection using Spring Security and JWT (JSON Web Tokens).

🚀 Technologies Used
Spring Boot: Framework for building robust Java applications.

Spring Security: Powerful framework for authentication and authorization.

Spring Data JPA: Abstraction for data access, facilitating interaction with relational databases.

PostgreSQL: Relational database management system.

JWT (JSON Web Tokens): Standard for creating secure access tokens.

BCrypt: Password hashing algorithm for secure encryption.

Lombok: Library that reduces Java code verbosity.

✨ Features
User Registration: Allows new users to register in the application.

Login and JWT Token Generation: Authenticated users receive a JWT token for secure access to protected routes.

Route Protection: Specific endpoints are protected and require authentication via JWT.

Role-Based Authorization: Differentiation between users with USER and ADMIN profiles, controlling access to certain functionalities or resources.

Password Encryption: Use of BCrypt to securely store passwords in the database.

⚙️ Prerequisites
Before running the project, make sure you have the following installed:

Java Development Kit (JDK) 17 or higher

Maven

PostgreSQL: A running PostgreSQL server.

🚀 How to Run the Project
Follow the steps below to set up and run the project locally:

Clone the repository:

git clone <YOUR_REPOSITORY_URL>
cd <PROJECT_FOLDER_NAME>

PostgreSQL Database Configuration:

Create a new database in PostgreSQL (e.g., auth_db).

Update the src/main/resources/application.properties file with your PostgreSQL credentials:

spring.datasource.url=jdbc:postgresql://localhost:5432/auth_db
spring.datasource.username=your_postgres_username
spring.datasource.password=your_postgres_password
spring.jpa.hibernate.ddl-auto=update # Or create, to automatically create tables
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

Build the Project:

mvn clean install

Run the Application:

mvn spring-boot:run

The application will be accessible at http://localhost:8080 by default.

🔑 API Endpoints
Here are the main API endpoints:

POST /auth/register: Registers a new user.

Request Body (JSON):

{
    "username": "newUser",
    "password": "securePassword",
    "role": "USER" // or "ADMIN"
}

POST /auth/login: Logs in and returns a JWT token.

Request Body (JSON):

{
    "username": "existingUser",
    "password": "yourPassword"
}

Response (JSON):

{
    "token": "eyJhbGciOiJIUzI1NiIsIn..."
}

GET /api/public: Example of a public route (does not require authentication).

GET /api/user: Example of a protected route for users with USER or ADMIN profile.

Required Header: Authorization: Bearer YOUR_JWT_TOKEN

GET /api/admin: Example of a protected route only for users with ADMIN profile.

Required Header: Authorization: Bearer YOUR_JWT_TOKEN

🧪 Testing the Application
You can use tools like Postman, Insomnia, or curl to test the API endpoints.

Register a user.

Log in with the registered user to obtain the JWT token.

Use the JWT token in the Authorization: Bearer YOUR_TOKEN header to access protected routes.
