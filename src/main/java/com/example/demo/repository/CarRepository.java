package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {

	//@Query(nativeQuery = true, value = "select count(*) from car")
	@Query(nativeQuery = true, value = "select sum(price) from car")
	public long getAllCarCount();

}