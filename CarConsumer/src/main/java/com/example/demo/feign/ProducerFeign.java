package com.example.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Car;

@FeignClient(name="Car-Service", url = "http://localhost:8081")
public interface ProducerFeign {

	@GetMapping("/cars/getallcars")
	List<Car> getAllCars();
	
	@GetMapping("/car/{brand}/{fuel}")
	ResponseEntity<List<Car>> sortByBrandAndFuel(@PathVariable String brand,String fuel);
	
	@GetMapping("/car/{brand}/{fuel}")
	List<Car> findAll(@RequestParam String brand,@RequestParam String fuel,@RequestParam String transmission);
	
	 // List<Car> soryByFuelType(); 
	//  List<Car> sortByPrice(); 
	 // List<Car> sortByTransmission();
	 
}
