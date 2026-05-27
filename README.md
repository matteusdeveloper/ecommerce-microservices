# Ecommerce Microservices Architecture 🛒

Sistema de e-commerce distribuído desenvolvido para demonstrar uma arquitetura baseada em microsserviços, utilizando comunicação entre serviços via API REST e persistência isolada.

---

# 📋 Visão Geral

Este projeto simula o fluxo principal de um e-commerce moderno, separando responsabilidades entre diferentes serviços independentes.

O objetivo principal é demonstrar:

- Arquitetura de microsserviços
- Desacoplamento entre serviços
- Comunicação via API REST
- Persistência de dados isolada
- Escalabilidade e organização backend

---

# 🧱 Arquitetura do Sistema

O sistema foi dividido em dois serviços principais:

## 🔹 Core API
Responsável por:

- Processamento de pedidos
- Validação de estoque
- Regras de negócio
- Persistência de dados

## 🔹 Notification Service
Responsável por:

- Recebimento de eventos
- Notificações de pedidos
- Comunicação entre serviços

---

# 🛠️ Stack Tecnológica

| Camada | Tecnologia | Finalidade |
|---|---|---|
| Core API | Java 17 + Spring Boot | Processamento de pedidos |
| Notification Service | Node.js + Express | Serviço de notificações |
| Banco de Dados | PostgreSQL 15 | Persistência relacional |
| Infraestrutura | Docker Compose | Containers e orquestração |

---

# 📁 Estrutura do Projeto

```bash
.
├── core/                   # Serviço principal Spring Boot
├── notification-service/   # Serviço Node.js
├── docker-compose.yml
└── README.md

✨ Funcionalidades
✅ Checkout de pedidos
✅ Validação transacional de estoque
✅ Atualização automática do inventário
✅ Comunicação entre microsserviços
✅ Persistência desacoplada
✅ Arquitetura escalável
⚙️ Pré-requisitos

Antes de iniciar o projeto, instale:

Docker Desktop
JDK 17+
Node.js v24+
Git
VS Code (Opcional)

# 🚀 Como Executar o Projeto

## 1️⃣ Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/seu-repositorio.git
cd seu-repositorio
```

---

## 2️⃣ Suba o banco de dados com Docker

```bash
docker compose up -d
```

---

## 3️⃣ Inicie o serviço Core API

Abra um terminal:

```bash
cd core
./mvnw spring-boot:run
```

### Windows (caso necessário)

```bash
mvnw spring-boot:run
```

---

## 4️⃣ Inicie o Notification Service

Abra outro terminal:

```bash
cd notification-service
npm install
node server.js
```

---

# 🧪 Exemplo de Requisição

## Endpoint

```http
POST /orders
```

## Body JSON

```json
{
  "customerId": 1,
  "items": [
    {
      "productId": 10,
      "quantity": 2
    }
  ]
}
```

---

# 🔄 Fluxo de Funcionamento

```text
Cliente → Core API → Banco de Dados
                    ↓
          Notification Service
```
Fluxo:
Cliente envia um pedido
Core API valida estoque
Pedido é processado
Estoque é atualizado
Serviço de notificações é acionado
---

# 🐳 Docker

## Subir containers

```bash
docker compose up -d
```

## Ver containers ativos

```bash
docker ps
```

## Derrubar containers

```bash
docker compose down
```

---

📌 Melhorias Futuras
Implementação de API Gateway
Autenticação JWT
Mensageria com RabbitMQ/Kafka
Kubernetes
CI/CD
Observabilidade com Prometheus e Grafana
Testes automatizados

👨‍💻 Autor

Desenvolvido por Matheus de Andrade.

📄 Licença

Este projeto está sob a licença MIT.
