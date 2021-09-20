package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.MathUtils;
import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public List<Car> getAllCars() {
		//return carRepository.findAll();
		//Paginataion and Sorting
		/*Pageable pageable = PageRequest.of(1,2,Sort.by("model").ascending());
		Page<Car> page = carRepository.findAll(pageable);
		return page.toList();*/
		//System.out.println(carRepository.getAllCarCount());
		List<Car> cars = carRepository.findAll();
		System.out.println(cars);
		return cars;
	}
	
	public Car save(Car car) {
		//MathUtils mathUtils = new MathUtils();
		//int a = mathUtils.calculateMultiplication(2,5);
		 return carRepository.save(car);
		
	}
	public void delete(int id) {
		 carRepository.deleteById(id);
		
	}
	

	
	public Car getCar(int id) {
		Optional<Car> optCar = carRepository.findById(id);
		if(optCar.isPresent()) {
			return optCar.get();
		 }
		else {
			return null;
		}
	}
	
	public Object update(int id, Car car) {
		/*MathUtils mathUtils = new MathUtils();
		int add = mathUtils.calculate(2,5);*/
		
		Optional<Car> optCar = carRepository.findById(id);
		if(!optCar.isPresent()) {
			return ResponseEntity.noContent().build();
			}
		Car c = optCar.get();
		c.setModel(car.getModel());
		c.setPrice(car.getPrice());
		 
		 return carRepository.save(c);
		
		}
	
	/*public String update(int id, Car car) {
		Optional<Car> optCar = carRepository.findById(id);
		if(optCar.isPresent()) {
				Car c = optCar.get();
				c.setModel(car.getModel());
				c.setPrice(car.getPrice());
				 carRepository.save(c);
				 return "Car Update Succesfully with Id "+c.getId();
			}
		else {
			return "Car not present with Id "+id;
		}
		
		}*/
	
	
	}
