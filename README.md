# Cadastro de Servidores - SEPLAG/MT

Projeto desenvolvido como parte do Processo Seletivo da SEPLAG/MT.

---

## Executando o projeto

### Pré-requisitos:
- Docker e Docker Compose instalados
- Java 21
- Maven

### Subindo os containers (PostgreSQL + MinIO):
```bash
docker-compose up
```

Isso irá iniciar:
- PostgreSQL (porta 5432) com banco `cadastro_servidores` e usuário `admin`/`admin`
- MinIO (portas 9000/9001) com usuário `minioadmin`/`minioadmin`

### Rodando o projeto Spring Boot:
```bash
./mvnw spring-boot:run
```

A API será acessível em `http://localhost:8080`

---

## Login padrão para testes

- **Usuário:** admin
- **Senha:** 123456

Um token JWT pode ser obtido via:
```http
POST /login
{
  "login": "admin",
  "senha": "123456"
}
```

---

## Informações do candidato

- **Nome:** Rafael Ramalho Silveira
- **CPF:** 046.110.881-03
- **Número de inscrições: 8994, 8991, 8989

---

## Observações

- Ao iniciar o container, o banco já é populado com o login padrão via `init.sql`
- As credenciais estão configuradas para desenvolvimento e devem ser alteradas para produção.

---

Feito com dedicação e muito café.
