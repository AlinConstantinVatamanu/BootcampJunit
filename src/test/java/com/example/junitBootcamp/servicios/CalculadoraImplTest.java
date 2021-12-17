package com.example.junitBootcamp.servicios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CalculadoraImplTest {

	@Test
	void testSuma() {
		CalculadoraImpl calculadora = new CalculadoraImpl();
		double res = calculadora.suma();
		assertEquals(2D, res);
	}
	
	@Test
	void testResta() {
		CalculadoraImpl calculadora = new CalculadoraImpl();
		double res = calculadora.resta(3D, 2D);
		assertEquals(1D, res);
	}
	
	@Test
	void testDevolverLista() {
		CalculadoraImpl calculadora = new CalculadoraImpl();
		List<Double> res = calculadora.devolverLista();
		assertNotNull(res);
		assertNotEquals(0, res.size());
		assertEquals(3, res.size());
		assertEquals(2D, res.get(1));
	}

}
