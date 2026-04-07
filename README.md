# Imobiliária API
[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)

API RESTful desenvolvida para a gestão completa de inquilinos, imóveis e contratos de aluguel. O projeto foca em **Clean Code**, alta performance com otimização de persistência e documentação interativa.

---

## Tecnologias e Ferramentas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.3.3
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** **PostgreSQL** (Produção) e H2 (Desenvolvimento/Testes)
* **Documentação:** SpringDoc OpenAPI (Swagger UI)
* **Mapeamento:** ModelMapper & DTOs
* **Build:** Maven

---

## 🏗️ Arquitetura e Boas Práticas

A aplicação segue a arquitetura em camadas para garantir escalabilidade e manutenção simplificada:
* **Controller:** Gerenciamento dos endpoints e contratos da API.
* **Service:** Concentração das regras de negócio e validações.
* **Repository:** Abstração da camada de dados com foco em eficiência.
* **DTO:** Separação entre modelos de banco de dados e dados trafegados pela rede.

### Acessando a documentação:
```bash
http://localhost:8080/swagger-ui/index.html
```
