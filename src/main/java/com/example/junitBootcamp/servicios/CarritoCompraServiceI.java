package com.example.junitBootcamp.servicios;

import java.util.List;

import com.example.junitBootcamp.model.Articulo;

public interface CarritoCompraServiceI {

	public void limpiarCesta();
	
	public void addArticulo(Articulo a);
	
	public Integer getNumArticulo();
	
	public List<Articulo> getArticulos();
	
	public Double totalPrice();
	
	public Double calculadorDescuento(Double precio, Double procentajeDescuento);
	
	public Double aplicarDescuento(Integer id, Double procentaje);
	
	public Integer insertar(Articulo articulo);
	
}
