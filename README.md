# 🏡 Imobiliária API

API RESTful desenvolvida em Spring Boot 3.3.3 para gerenciar Inquilinos, Imóveis e Aluguéis. O projeto utiliza Spring Data JPA e um banco de dados H2 em memória para prototipagem e desenvolvimento.

---

## 🚀 Tecnologias

* **Linguagem:** Java 17+
* **Framework:** Spring Boot 3.3.3
* **Banco de Dados:** H2 (Em memória, para desenvolvimento) e PostgreSQL
* **Persistência:** Spring Data JPA / Hibernate
* **Documentação:** SpringDoc OpenAPI (Swagger UI 2.5.0)
* **Mapeamento de DTO:** ModelMapper
* **Gerenciamento de pacotes:** Maven

---

## 📦 Estrutura do Projeto

O projeto segue a arquitetura em camadas (Controller, Service, Repository) e utiliza DTOs (Data Transfer Objects) para a comunicação com a API.
Com certeza\! Compilando seus *controllers* e o contexto do seu projeto imobiliário (gestão de Inquilinos, Imóveis e Aluguéis) em um arquivo **README.md** profissional.

Este README inclui seções sobre a estrutura, como rodar, e a documentação da API.

---

## 🛠️ Como Rodar a Aplicação

### Pré-requisitos

* JDK 17 ou superior
* Apache Maven ou Maven Wrapper (integrado à IDE)

### Passos

1.  **Clone o repositório:** (Assumindo que o código está em um repositório git)
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    cd Desafio-Imobiliaria
    ```

2.  **Compile e Empacote o projeto:**
    O comando `clean install` limpa, compila, executa os testes e gera o JAR executável.
    ```bash
    ./mvnw clean install
    ```

3.  **Execute o JAR:**
    Após o *build*, execute o arquivo JAR gerado na pasta `target/`.
    ```bash
    java -jar target/Desafio-Imobiliaria-0.0.1-SNAPSHOT.jar
    ```

A aplicação será iniciada na porta padrão **8080**.

---

## 🌐 Documentação da API (Swagger UI)

A documentação interativa da API está disponível no seu navegador:

**URL:** `http://localhost:8080/swagger-ui/index.html`

---

## 📝 Endpoints da API

| Recurso | Método | Path | Descrição |
| :--- | :--- | :--- | :--- |
| **Inquilinos** | `POST` | `/inquilinos` | Cria um novo inquilino. |
| | `GET` | `/inquilinos/{id}` | Busca um inquilino pelo ID. |
| | `DELETE` | `/inquilinos/{id}` | Exclui um inquilino pelo ID. |
| **Imóveis** | `POST` | `/imoveis` | Cria um novo imóvel. |
| | `GET` | `/imoveis/{id}` | Busca um imóvel pelo ID. |
| | `DELETE` | `/imoveis/{id}` | Exclui um imóvel pelo ID. |
| **Aluguéis** | `POST` | `/alugueis?inquilino={id_inq}&imovel={id_imo}` | Cria um novo aluguel, associando-o a um Inquilino e um Imóvel existentes. |
| | `GET` | `/alugueis/{id}` | Busca um aluguel pelo ID. |
| | `GET` | `/alugueis/atrasados` | Lista todos os aluguéis com data de vencimento no passado e que não foram pagos (`pago=false`). |
| | `PATCH` | `/alugueis/{id}/pagar` | Marca um aluguel específico como pago. |
| | `DELETE` | `/alugueis/{id}` | Exclui um aluguel. |
