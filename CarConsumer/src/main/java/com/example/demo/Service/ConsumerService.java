package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Car;
import com.example.demo.feign.ProducerFeign;

@Service
public class ConsumerService {

	@Autowired
	private ProducerFeign feign;
	

	
	
	public List<Car> sortByCarBrandAndFuel(String brand, String fuel) {
		List<Car> carDetails  = feign.getAllCars();
		System.out.println("carDetails:"+carDetails);
		
		List<Car> brabd = new ArrayList<>();
		for(Car car: carDetails) {
			
			if(car.getCarBrand().equalsIgnoreCase(brand) && car.getFuelType().equalsIgnoreCase(fuel)) {
				brabd.add(car);
			}
		}
			return brabd;
		
		
		
	}
	
	public List<Car> getAllDet(String brand,String fuel,String transmission) {
		List<Car> findAll = feign.getAllCars();
		System.out.println("All Details :" + findAll);
		List<Car> filteredCars = findAll.stream()
			    .filter(car -> car.getCarBrand().equalsIgnoreCase(brand))
			    .filter(car -> car.getFuelType().equalsIgnoreCase(fuel))
			    .filter(car -> car.getTransmission().equalsIgnoreCase(transmission))
			    .collect(Collectors.toList());

			return filteredCars;

	}
	
	
	
	public List<Car> sortAll(String brand,String fuel,double price,String transmission){
		List<Car> allCars = feign.getAllCars();
		List<Car> collect = allCars.stream().
		filter(car -> car.getCarBrand().equalsIgnoreCase(brand))
		.filter(car->car.getFuelType().equalsIgnoreCase(fuel))
		.filter(car->car.getTransmission().equalsIgnoreCase(transmission))
		.filter(car->car.getPrice() <=price)
		.filter(car->car.getPrice()>=price)
				.collect(Collectors.toList());
		return collect;
	}
	
	
//	public List<Car> sortByfuel() {
//		return feign.soryByFuelType();
//	}
//	
//	public List<Car> sortByPrice(){
//		return feign.sortByPrice();
//	}
//	
//	public List<Car> sortByTrans(){
//		return feign.sortByTransmission();
//	}
	
	}
