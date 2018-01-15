package es.luciajorda.comparadorprecios.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/producto")
	public void createProducto(@RequestBody Producto producto, HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Location", request.getRequestURL().
				append("/").
				append(this.productoService.createProducto(producto).getId()).toString());
	}
	
	@PutMapping("/producto/{id}")
	public void updateProducto(@PathVariable("id") Long id,@RequestBody Producto producto) {
		Producto update = this.productoService.getProducto(id);
		update.setName(producto.getName());
		this.productoService.createProducto(update);
	}

}
