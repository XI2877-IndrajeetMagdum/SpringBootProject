package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Training {
		@Id
		@GeneratedValue
		public int id;
		private String training_name;
			
		/*@ManyToMany(mappedBy="trainings")
		private Set<Car> cars;*/
		
	}
