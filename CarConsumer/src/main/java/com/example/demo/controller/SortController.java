package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ConsumerService;
import com.example.demo.entity.Car;

@RestController
public class SortController {

	@Autowired
	private ConsumerService service;
	
	@GetMapping("/car")
	public List<Car> sortByBrandAndFuel(@RequestParam String brand,@RequestParam String fuel){
		if(brand!=null)
		{
			return service.sortByCarBrandAndFuel(brand,fuel);
		}
		else if(fuel!=null) {
			return service.sortByCarBrandAndFuel(brand,fuel);
		}
		else return null;
	
	}
	
	@GetMapping("/cars")
	public List<Car> getCar(@RequestParam String brand,
			@RequestParam String fuel,
			@RequestParam String transmission){
	return	service.getAllDet(brand, fuel, transmission);
		
	}
	
	@GetMapping("/sortall")
	public List<Car> getall(@RequestParam String brand,
			@RequestParam String fuel, @RequestParam Double price,
			@RequestParam String transmission){
		System.out.println("fetched");
		return service.sortAll(brand, fuel, price,transmission);
	}
		
	}
	
	
	
