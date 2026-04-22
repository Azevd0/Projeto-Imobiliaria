# Imobiliária API
[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Container-blue?style=for-the-badge&logo=docker)](https://www.docker.com/)

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

## Arquitetura e Boas Práticas

A aplicação segue a arquitetura em camadas para garantir escalabilidade e manutenção simplificada:
* **Controller:** Gerenciamento dos endpoints e contratos da API.
* **Service:** Concentração das regras de negócio e validações.
* **Repository:** Abstração da camada de dados com foco em eficiência.
* **DTO:** Separação entre modelos de banco de dados e dados trafegados pela rede.

## Configurando as Variáveis de Ambiente (.env)
Este projeto utiliza variáveis de ambiente para proteger dados sensíveis.

1. Na raiz do projeto, localize o arquivo `.env.example`.
2. Faça uma cópia deste arquivo e renomeie a cópia para **`.env`**.
3. Abra o seu novo arquivo `.env` e preencha com as senhas e usuários que você deseja utilizar no seu banco local:
   ```env
   DB_USER=seu_usuario_aqui
   DB_PASSWORD=sua_senha_aqui
   DB_NAME=orderfactory
   ```
4. Para que sua IDE saiba ler o .env, atualize suas configurações de run para que possa receber bem o arquivo.
* Intellij: instale o plugin EnvFile, vá nas configurações de run -> Edit -> marque Enable Envfile -> selecione seu arquivo.env
* VS Code: baixe a extensão Spring Boot Extension Pack, ele lida automaticamente com o .env
* Eclipse: clique com o botão direito no projeto -> Run As -> Run Configurations....
Selecione sua aplicação em Spring Boot App ou Java Application. Vá na aba Environment.
Aqui, você terá que clicar em Add... e colocar cada variável manualmente (DB_USER, DB_PASSWORD, etc.).

## Executando perfis

Para executar o perfil de testes, apenas dê startup na aplicação, certificando-se de que o spring.profiles.active no application.properties está como "test"

Para executar o perfil de produção, primeiro entre na raíz do projeto e use o comando 
```bash
docker compose up -d --build
```
Isso vai levar um tempo até o binário ser gerado e a imagem criada.
Com o build completo a aplicação está pronta para receber requisições pelo swagger:
```bash
http://localhost:8080/swagger-ui/index.html
```
Nas vezes subsequentes que for rodar a aplicação use o comando sem --build, use apenas quando precisar atualizar a imagem caso tenha feito alguma alteração.
```bash
docker compose up -d
```
Para ver o tempo de startup da aplicação, abra os logs com:
```bash
docker compose logs api
```
