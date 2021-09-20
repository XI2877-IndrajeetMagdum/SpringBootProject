package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MathUtilsTests {

	@Test
	public void testCalculation() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(6,mathUtils.calculateMultiplication(2, 3));
	}
}
