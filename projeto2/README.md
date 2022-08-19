# Projeto 2

Nsste projeto mosta a configuração de envio e recebimento de mensagems. Utilizaremos o projeto 1 como base.

## Configuração

```java
// Configura consumidor
@Bean
public RabbitListenerContainerFactory<DirectMessageListenerContainer> rabbitListenerContainerFactory(
		ConnectionFactory connectionFactory) {
	...
}
```

## Teste

### Postman

![](../assets/postman.PNG)

### Curl

```bash
curl --location --request POST 'http://localhost:8080/v1/orders' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "value": 10,
    "paid": true,
    "data": "2022-08-19 12:00:03"
}'
```
