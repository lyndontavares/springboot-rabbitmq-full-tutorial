# Projeto 1

Iniciando com RabbitMQ.

## Docker

```shell
docker-compose up -d
```

## Run

```shell
mvn spring-boot:run
```

## Importante

Configuração do rabbitmq com o sprintboot:

### Applicatioin.yml

A adminstração do RabbitMQ é feita pela url: http://localhost:5672, usando usuário e senha conforme configuração abaixo.

```yml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: admin
    password: 123456
```

![](../assets/rabbit-login.png)

### RabbitMQConfig.java

```java

 @Bean
 public Queue queue() {
     return new Queue("order");
 }

 @Bean
 public RabbitAdmin rabbitAdmin(ConnectionFactory connection) {
    return new RabbitAdmin(connection);
 }

 @Bean
 public ApplicationListener<ApplicationReadyEvent> applicationListener(RabbitAdmin rabbittAdmin) {
    return event -> rabbittAdmin.initialize();
 }

 @Bean
 public Jackson2JsonMessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
 }

@Bean
public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                     Jackson2JsonMessageConverter messageConverter) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(messageConverter);
    return rabbitTemplate;
}
```
