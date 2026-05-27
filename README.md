## Ecommerce Microservices Architecture 🛒

## 📋 Visão Geral
Este projeto é um sistema de e-commerce distribuído, desenvolvido para demonstrar a implementação de uma arquitetura de microsserviços. O foco principal foi garantir o **desacoplamento** entre o serviço de processamento de pedidos (Core) e o serviço de notificações, utilizando comunicação via API REST e persistência de dados isolada.

## 📐 Arquitetura do Sistema
O fluxo de comunicação entre os serviços garante que o processamento do pedido seja independente do serviço de notificação.

## 🛠️ Stack Tecnológica
| Camada | Tecnologia | Propósito |
| :--- | :--- | :--- |
| **Core API** | Java 17, Spring Boot | Processamento de transações, regras de estoque. |
| **Notificações** | Node.js, Express | Serviço de alerta de pedidos. |
| **Banco de Dados**| PostgreSQL 15 | Persistência relacional. |
| **Infraestrutura** | Docker Compose | Orquestração de containers. |

## 🚀 Funcionalidades
- **Checkout de Pedidos:** Validação transacional de disponibilidade de estoque.
- **Gestão de Estoque:** Atualização automática do inventário via banco de dados.
- **Notificações:** Comunicação inter-serviços para confirmação de eventos.

## ⚙️ Como Executar o Projeto

### Pré-requisitos
* Docker Desktop instalado.
* JDK 17+.
* Node.js v24+.

### Passos para rodar
1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/SEU-USUARIO/seu-repositorio.git](https://github.com/SEU-USUARIO/seu-repositorio.git)

Suba o banco de dados (Docker):

Bash
docker compose up -d
Inicie o serviço Core (Spring Boot):
(Navegue até a pasta core)

Bash
./mvnw spring-boot:run
Inicie o serviço de Notificações (Node.js):
(Em um novo terminal, navegue até a pasta notification-service)

Bash
cd notification-service
npm install
node server.js

---

### 2. Passo a passo para upar no GitHub (Terminal do VS Code)

Com o arquivo criado, execute estes comandos no terminal do VS Code (na pasta raiz):

1. **Inicie o controle de versão:**
   ```bash
   git init