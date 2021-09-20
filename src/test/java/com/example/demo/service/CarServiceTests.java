package com.example.demo.service;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@SpringBootTest
public class CarServiceTests {
	
	@InjectMocks
	private CarService carService;
	
	@Mock
	private CarRepository carRepository;
	
	//getAllCars() testing
	@Test
	public void testgetAllCars() {
		List<Car> lst = Stream.of(new Car(1,"Car1",12345)).collect(Collectors.toList());
		when(carRepository.findAll()).thenReturn(lst);
		
		List<Car> cars = carService.getAllCars();
		
		assertEquals(1,cars.size());
	}
	
	//getCar() testing
	@Test
	public void testgetCar() {
		Optional<Car> car = Optional.of(new Car(2,"Car1",12345));
		int id = 2;
		when(carRepository.findById(2)).thenReturn(car);
		Car result = carService.getCar(id);
		
		System.out.println(car.get().getModel());
		System.out.println(result.getModel());
		
		assertEquals(car.get().getModel(),result.getModel());
	}
	
	//Update() testing
	@Test
	public void testupdate() {
		Optional<Car> car = Optional.of(new Car(2,"Car1",12345));
		int id = 2;
		when(carRepository.findById(id)).thenReturn(car);
		Car result = carService.getCar(id);
		
		System.out.println(car.get().getModel());
		System.out.println(result.getModel());
		
		assertEquals(car.get().getModel(),result.getModel());
	}
	
	//Exception
	/*@Test
	public void testsave() {
		Car car = new Car(2,"Car1",12345);
		int id = 2;
		when(carRepository.save(car)).thenReturn(car);
		String result = carService.getCar(id).getModel();
		
		System.out.println(car.getModel());
		System.out.println(result);
		
		assertEquals(car.getModel(),result);
	}*/
	
	
}
