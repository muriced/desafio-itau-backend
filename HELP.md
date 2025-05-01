# Desafio Itaú Backend

Este projeto é uma API REST desenvolvida em Java com Spring Boot para gerenciar transações financeiras e fornecer estatísticas agregadas das transações realizadas nos últimos 60 segundos.

## Funcionalidades

- **Registrar transações:** Permite criar novas transações financeiras informando valor e data/hora.
- **Consultar estatísticas:** Retorna soma, média, mínimo, máximo e quantidade de transações dos últimos 60 segundos.
- **Remover transações:** Permite limpar todas as transações registradas.

## Endpoints

### `POST /transacao`

Cria uma nova transação.

**Request Body:**
```json
{
  "valor": 100.50,
  "dataHora": "2024-05-01T12:00:00Z"
}
```
- **201 Created:** Transação criada com sucesso.
- **422 Unprocessable Entity:** Data futura ou valor menor/igual a zero.

---

### `GET /estatisticas`

Retorna estatísticas das transações dos últimos 60 segundos.

**Response Body:**
```json
{
  "count": 2,
  "sum": 200.00,
  "avg": 100.00,
  "min": 100.00,
  "max": 100.00
}
```

---

### `DELETE /transacao`

Remove todas as transações registradas.

- **200 OK:** Transações removidas com sucesso.

## Como executar

1. Certifique-se de ter o Java 17+ e o Maven instalados.
2. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
   ```
3. Acesse a pasta do projeto:
   ```bash
   cd desafio-itau-backend
   ```
4. Execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

## Testes

## Observações

- Todos os valores monetários são formatados com duas casas decimais.
- As datas devem estar no formato ISO 8601 (`yyyy-MM-dd'T'HH:mm:ssX`).

---