# Microserviço em Java Spring Boot com RabbitMQ

Este projeto é a criação de um microserviço reponsável por receber requisições e gerar mensagens
para os demais microsserviços, que são os consumidores da mensagem.

## Produtor/Consumidor
1 produtor em java com spring
1 consumidor em java com spring
1 consumidor em nodejs.

Adicionado configuração do Prefecth Count do RabbitMQ.

Vídeos com implementações deste projeto: https://www.youtube.com/playlist?list=PL1OeYyl9zqzHDN67rto7KMtezTLmk1N-K

![Projeto](https://user-images.githubusercontent.com/51996690/120472712-9cdca900-c37c-11eb-967d-a4749f764c4e.png)


## RabbitMQ

```bash
docker-compose up -d
```

![](assets/rabbit.PNG)

## Teste

### Postman

![](assets/postman.PNG)

### Curl

```bash
curl --location --request PUT 'http://localhost:8080/preco' \
--header 'Content-Type: application/json' \
--data-raw '{
    "codigoproduto":"001",
    "preco":1000
}'
```
