package com.mycompany.springbootrabbitinit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mycompany.springbootrabbitinit.consts.Filas;
import com.mycompany.springbootrabbitinit.dto.Order;

@Component
public class EstoqueConsumer {

  @RabbitListener(queues = Filas.FILA_ORDER)
  private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException {
    
	ObjectMapper mapper = new ObjectMapper();  
	mapper.registerModule(new JavaTimeModule());
	mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	
	Order order = mapper.readValue(mensagem, Order.class);
	
	System.out.println(">>> Consumiindo fila (order): ");
	System.out.println(order);
  }
  
}
