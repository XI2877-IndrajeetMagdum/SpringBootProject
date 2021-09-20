package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SomeTests {

	@Test
	public void testCalculation() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(5,mathUtils.calculate(2, 3));
		assertEquals(-5,mathUtils.calculate(-2, -3));
		assertEquals(1,mathUtils.calculate(-2, 3));
		assertEquals(0,mathUtils.calculate(0, 0));
	}
}
