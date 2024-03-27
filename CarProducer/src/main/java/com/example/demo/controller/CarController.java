package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.car.Car;
import com.example.demo.services.CarServices;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarServices service;
	
	@PostMapping("/add")
	public ResponseEntity<List<Car>> addModels(@RequestBody List<Car> car){
	List<Car> saveCar = service.saveCar(car);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCar);
	}
	
	@GetMapping("/getallcars")
	public ResponseEntity<List<Car>> getAllCar() {
    List<Car> car = service.getCar();
		return new ResponseEntity<>(car,HttpStatus.OK);
	}
	
	

	
}
