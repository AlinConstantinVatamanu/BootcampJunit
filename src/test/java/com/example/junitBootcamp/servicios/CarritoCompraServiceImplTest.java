package com.example.junitBootcamp.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.junitBootcamp.bbdd.BaseDatosImpl;
import com.example.junitBootcamp.model.Articulo;


@ExtendWith(MockitoExtension.class)
class CarritoCompraServiceImplTest {
	
	@InjectMocks
	private CarritoCompraServiceImpl carritoService = new CarritoCompraServiceImpl();

	@Mock
    private BaseDatosImpl baseDatosMock;
	

	@Test
	void testLimpiarCesta() {
		assertEquals(0, carritoService.getNumArticulo());
		carritoService.addArticulo(new Articulo("Camisa", 30.00));
		assertEquals(1, carritoService.getNumArticulo());
		carritoService.limpiarCesta();
		assertEquals(0, carritoService.getNumArticulo());
	}

	@Test
	void testAddArticulo() {
		assertEquals(0, carritoService.getNumArticulo());
		carritoService.addArticulo(new Articulo("Camisa", 30.00));
		assertEquals(1, carritoService.getNumArticulo());
		carritoService.addArticulo(new Articulo("Calcetines", 10.00));
		assertEquals(2, carritoService.getNumArticulo());
		
		List<Articulo> articulos = carritoService.getArticulos();
		assertEquals(articulos.get(0).getNombre(), "Camisa");
		assertEquals(articulos.get(0).getPrecio(), 30D);
		
		assertEquals(articulos.get(1).getNombre(), "Calcetines");
		assertEquals(articulos.get(1).getPrecio(), 10D);
	}

	@Test
	void testGetNumArticulo() {
		carritoService.addArticulo(new Articulo("Pantalón", 30.00));
		carritoService.addArticulo(new Articulo("Camiseta", 10.00));
		carritoService.addArticulo(new Articulo("Camisa", 20.00));
		
		List<Articulo> articulos = carritoService.getArticulos();
		assertEquals(3, articulos.size());
		assertNotEquals(0, articulos.size());
	}

	@Test
	void testGetArticulos() {		
		carritoService.addArticulo(new Articulo("Pantalón", 30.00));
		carritoService.addArticulo(new Articulo("Camiseta", 10.00));
		List<Articulo> articulos = carritoService.getArticulos();
		assertEquals(2, carritoService.getNumArticulo());
		assertEquals(articulos.get(0).getNombre(), "Pantalón");
		assertEquals(articulos.get(0).getPrecio(), 30D);
		assertEquals(articulos.get(1).getNombre(), "Camiseta");
		assertEquals(articulos.get(1).getPrecio(), 10D);
		assertNotNull(articulos);
	}

	@Test
	void testTotalPrice() {
		assertEquals(0.00, carritoService.totalPrice());
		carritoService.addArticulo(new Articulo("Pantalón", 30.00));
		carritoService.addArticulo(new Articulo("Camiseta", 10.00));
		assertEquals(40.00, carritoService.totalPrice());
		assertNotEquals(30.00, carritoService.totalPrice());
	}

	@Test
	void testCalculadorDescuento() {
		Double descuento = carritoService.calculadorDescuento(100D, 10D);
		assertEquals(10D, descuento);
		assertNotEquals(90D, descuento);
	}

	@Test
	void testAplicarDescuento() {
		Articulo articulo = new Articulo("Camiseta", 20.00);
		when(baseDatosMock.findArticuloById(any(Integer.class))).thenReturn(articulo);
		Double res = carritoService.aplicarDescuento(1, 10D);
		assertEquals(2D, res);
		verify(baseDatosMock).findArticuloById(any(Integer.class));
		//Se llama 2 veces
		//verify(baseDatosMock, times(2)).findArticuloById(any(Integer.class));
	}
	
	
	@Test
	void testInsertar() {
		Articulo articulo = new Articulo("Camiseta", 20.00);
		Integer identificador = carritoService.insertar(articulo);
		//when(baseDatosMock.insertarArticulo(any(Articulo.class))).thenReturn(identificador);
		List<Articulo> articulos = carritoService.getArticulos();
		
		assertEquals("Camiseta", articulos.get(identificador).getNombre());
		assertEquals(20D, articulos.get(identificador).getPrecio());
		verify(baseDatosMock, atLeast(1)).insertarArticulo(any(Articulo.class));
	}
}
