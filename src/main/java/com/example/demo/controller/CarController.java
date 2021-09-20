package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/cars")
	public ResponseEntity<List<Car>> getAllCar(){
		return ResponseEntity.ok(carService.getAllCars());
	}
	
	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> getCar(@PathVariable("id") int id){
		return ResponseEntity.ok(carService.getCar(id));
	}
	
	@PostMapping("/cars")
	public ResponseEntity<Car>  addCar(@RequestBody Car car) throws URISyntaxException{
		carService.save(car);
		URI uri = new URI("/cars/"+car.getId());
		System.out.println(ResponseEntity.created(uri).build());
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<Void> deleteCar(@PathVariable int id) {
	    try {
	        carService.delete(id);
	        return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.notFound().build();
	    }
	
	
	/*
	public String deleteCar(@PathVariable int id){
		carService.delete(id);
		return "car deleted succesfully";*/
			
	}
	
	@PutMapping("/cars/{id}")
	public Object updateCar(@RequestBody Car car, @PathVariable int id) {
		return ResponseEntity.ok(carService.update(id,car));
		//return carService.update(id,car);
	
	
	
	}
}
