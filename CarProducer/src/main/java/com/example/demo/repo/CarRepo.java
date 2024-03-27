package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.car.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer>{

	List<Car> findAllBycarBrand(String brand);
	List<Car> findAllBycarBrandAndFuelType(String carbrand,String fuelType);
	List<Car> findAllByFuelType(String fuelType);
	List<Car> findAllByPrice(double price);
	List<Car> findAllByTransmission(String transmission);
	List<Car> findAllBycarBrandAndFuelTypeAndTransmission(String carbrand,String fuelType,String transmission);
}
