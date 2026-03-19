package com.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequestDTO {
	public String productName;
	public int quantity;
	public double price;
	public String region;
	

}