package com.example.junitBootcamp.servicios;

import java.util.List;

public interface CalculadoraI {

	public Double suma();
	
	public Double resta(Double num1, Double num2);
	
	public List<Double> devolverLista();
}
