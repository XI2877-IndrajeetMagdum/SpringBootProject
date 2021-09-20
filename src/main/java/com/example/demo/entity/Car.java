package com.example.demo.entity;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {
	@Id
	@GeneratedValue
	public int id;
	private String model;
	private long price;
	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CarParts_id")    
	private CarParts carparts;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="car_id")
	Set<CarDetails> carDetails;
	
	@ManyToOne
	@JoinColumn(name="cs_id")
	private CarShowroom carshowroom;
	
	@ManyToMany
	@JoinTable(name="car_training",
			joinColumns=@JoinColumn(name="car_id"),
			inverseJoinColumns=@JoinColumn(name="training_id"))
	private Set<Training> trainings;*/
	
}
