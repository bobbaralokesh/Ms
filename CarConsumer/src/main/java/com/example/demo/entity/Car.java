package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Car {

	
	private Integer id;
	private String carBrand;
	private String fuelType;
	private double price;
	private String transmission;
	
}
