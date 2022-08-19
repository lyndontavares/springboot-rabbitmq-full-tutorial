package com.mycompany.springbootrabbitinit.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order {
	private Long id;
	private BigDecimal value = BigDecimal.ZERO;
	private Boolean paid = Boolean.FALSE;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime data;
}
