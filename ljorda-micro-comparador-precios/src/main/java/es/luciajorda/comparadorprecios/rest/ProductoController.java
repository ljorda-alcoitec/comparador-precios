package es.luciajorda.comparadorprecios.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.luciajorda.comparadorprecios.domain.Producto;
import es.luciajorda.comparadorprecios.service.ProductoService;


@RestController
public class ProductoController {
	
	@Autowired 
	private ProductoService productoService;
	
	@GetMapping("/producto")
	public List<Producto> getAll() {
		return this.productoService.getAllProductos();
	}
	
	@GetMapping("/producto/{id}")
	public Producto getProductById(@PathVariable("id") Long id) {
		return this.productoService.getProducto(id);
	}

}
