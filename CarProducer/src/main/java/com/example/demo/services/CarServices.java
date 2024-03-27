package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.car.Car;
import com.example.demo.repo.CarRepo;

@Service
public class CarServices {

	@Autowired
	private CarRepo repo;
	
	public List<Car> saveCar(List<Car> car) {
		try {
			 return repo.saveAll(car);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to save the car"+e.getMessage());
		}
		
		
	}
	
	public List<Car> getCar(){
		return repo.findAll();
	}
	

	
	
	
}
