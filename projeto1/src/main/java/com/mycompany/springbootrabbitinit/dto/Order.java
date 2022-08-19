package com.mycompany.springbootrabbitinit.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Order {
	private Long id;
	private BigDecimal value = BigDecimal.ZERO;
	private Boolean paid = Boolean.FALSE;
}
