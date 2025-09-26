# Sistema de Login Seguro com Spring Boot, Thymeleaf e MongoDB Atlas

## 📌 Visão Geral
Este projeto implementa um sistema de autenticação e autorização utilizando **Spring Boot**, **Spring Security**, **Thymeleaf** e **MongoDB Atlas**.  
Inclui funcionalidades de **cadastro, login, logout e controle de acesso baseado em roles**.

## 🚀 Tecnologias Utilizadas
- Java 21
- Spring Boot 3.5.6
- Spring Security
- Spring Data MongoDB
- Thymeleaf
- MongoDB Atlas

## 🔑 Funcionalidades
- Cadastro de novos usuários (com validação e hash de senhas via BCrypt)
- Login e Logout
- Controle de acesso baseado em perfis (USER, ADMIN)
- Páginas protegidas com Spring Security
- Estrutura modular para facilitar customizações

## 📂 Estrutura do Projeto
```
src/main/java/dev/joaogodoi/loginsystem
 ├── config          # Configurações de segurança
 ├── controller      # Controladores MVC
 ├── dto             # Objetos de transferência de dados
 ├── model           # Entidades do domínio (User, Role)
 ├── repository      # Interfaces de acesso ao MongoDB
 └── service         # Serviços e regras de negócio
```

## ⚙️ Configuração com MongoDB Atlas
1. Crie uma conta em [MongoDB Atlas](https://www.mongodb.com/atlas).
2. Crie um cluster gratuito.
3. Crie um banco de dados chamado `login_system` (ou outro nome de sua escolha).
4. Configure o usuário e senha no cluster.
5. No arquivo `src/main/resources/application.properties`, configure:
```
spring.data.mongodb.uri=mongodb+srv://<usuario>:<senha>@<cluster-url>/login_system?retryWrites=true&w=majority
spring.data.mongodb.database=login_system
```

## ▶️ Executando o Projeto
1. Clone o repositório ou extraia o ZIP.
2. Navegue até a pasta do projeto.
3. Execute:
```bash
./mvnw spring-boot:run
```
ou, se tiver o Maven instalado:
```bash
mvn spring-boot:run
```

4. Acesse no navegador:
- **Login:** [http://localhost:8080/login](http://localhost:8080/login)
- **Registro:** [http://localhost:8080/register](http://localhost:8080/register)
- **Dashboard (protegido):** [http://localhost:8080/dashboard](http://localhost:8080/dashboard)
- **Todos usuários (protegido, requer role de ADMIN):** [http://localhost:8080/admin/users](http://localhost:8080/admin/users)

## 👤 Usuários e Roles
- Ao se registrar, o usuário recebe automaticamente a role `ROLE_USER`.
- Você pode adicionar `ROLE_ADMIN` diretamente no MongoDB para testes de acesso administrativo.

Exemplo no MongoDB:
```json
{
  "username": "admin",
  "email": "admin@example.com",
  "password": "<hash_bcrypt>",
  "roles": ["ROLE_ADMIN"],
  "enabled": true
}
```

## 🎨 Customização de Layout
O projeto utiliza Thymeleaf com um layout base (`templates/layouts/base.html`) para facilitar a troca de temas.  
Basta alterar o template base para aplicar novos estilos em todas as páginas.

## 📖 Decisões de Design
- **Spring Security + BCrypt:** garante segurança na autenticação.
- **MongoDB Atlas:** banco escalável e fácil de integrar.
- **Arquitetura modular:** separação clara entre camadas (config, service, controller, etc.).
- **Thymeleaf layouts:** suporte para personalização de temas.
