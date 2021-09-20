package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


import com.example.demo.entity.Car;
import com.example.demo.service.CarService;
@WebMvcTest(controllers = CarController.class)
@ActiveProfiles("test")
public class CarControllerTests {

	@Autowired                           
    private MockMvc mockMvc;  
                                                 
    @MockBean                          
    private CarService carService; 
                                               
    private List<Car> carList;       
                                            
    @BeforeEach                           
    void setUp() {                               
       this.carList = new ArrayList<>();                            
       this.carList.add(new Car(1, "Car1",12345L));                    
       this.carList.add(new Car(2, "Car2",45678L));                   
       this.carList.add(new Car(3, "Car3",36888L));                                                       
 
    }

	//getAllCars() testing
	@Test
	public void testgetAllCars() throws Exception {
		when(carService.getAllCars()).thenReturn(carList);
		this.mockMvc.perform(get("/api/cars"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()",is(carList.size())));
		
	}
	
	//getCar() testing
	@Test
	public void testgetCar() throws Exception {
		final int id = 1;
		final Car car = new Car(1, "Car1",12345L);
		when(carService.getCar(id)).thenReturn(car);
		this.mockMvc.perform(get("/api/cars/{id}",id))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.model",is(car.getModel())));
		
	}
	
	
	
	
	//Exception
	/*@Test
	public void testupdate() throws Exception {
		final int id = 1;
		 final Car car = new Car(id, "Car1",12345L);
		
		when(carService.update(id,car)).thenReturn(car);
		
		
		this.mockMvc.perform(get("/api/cars/{id}",id))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.model",is(car.getModel())));
		
	}*/
}
