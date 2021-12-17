package com.example.junitBootcamp.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraImpl implements CalculadoraI {

	@Override
	public Double suma() {
		return (1D +1D);
	}

	@Override
	public Double resta(Double num1, Double num2) {
		return (num1 - num2);
	}

	@Override
	public List<Double> devolverLista() {
		List<Double> lista = new ArrayList<>();
		lista.add(1D);
		lista.add(2D);
		lista.add(3D);
		
		return lista;
	}

}
