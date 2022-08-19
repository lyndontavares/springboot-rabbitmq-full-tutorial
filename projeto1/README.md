# Projeto 1

Este projeto mostra configuração mínima para o rabbitMQ. Trata-se um app que expôe uma APi Rest para teste do envio de uma mensagem.
O exchange será o default (tipo:direct) e a fila será criada com nome 'order'.

São pré-requisitos:

* Docker
* Client Rest

## Docker

```shell
docker-compose up -d
```

## Run

```shell
mvn spring-boot:run
```

Configuração do rabbitmq com o sprintboot:

## Applicatioin.yml

```yml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: admin
    password: 123456
```

## Admin RabbitMQ

A adminstração do RabbitMQ é feita pela url: http://localhost:5672, usando usuário e senha conforme configuração abaixo.

![](../assets/rabbit-login.png)

## RabbitMQConfig.java

```java

	// Criar fila
	@Bean
	public Queue queue() {
		...
	}

	// Instância do rabbitMQ
	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connection) {
	   ...
	}

	// Inicializa rabbit
	@Bean
	public ApplicationListener<ApplicationReadyEvent> applicationListener(RabbitAdmin rabbittAdmin) {
		...
	}

	// Mapper serializção/deserialização
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		...
	}

	// Manipular filas
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
			Jackson2JsonMessageConverter messageConverter) {
      ...
	}
```
