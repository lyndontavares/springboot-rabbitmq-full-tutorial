package com.mycompany.springbootrabbitinit.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.springbootrabbitinit.consts.Filas;
import com.mycompany.springbootrabbitinit.dto.Order;

@RestController
@RequestMapping(value = "/v1/orders")
public class OrderController {
 
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping
	public Order create(@RequestBody Order order) {
	 	rabbitTemplate.convertAndSend(Filas.FILA_ORDER, order);
		return order;
	}
 
	
}