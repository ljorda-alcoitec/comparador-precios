package es.luciajorda.comparadorprecios.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.luciajorda.comparadorprecios.domain.Producto;
import es.luciajorda.comparadorprecios.service.ProductoService;


@RestController
public class ProductoController {
	
	@Autowired 
	private ProductoService productoService;
	
	@GetMapping("/producto")
	public ResponseEntity <List<Producto>> getAll() {
		List<Producto> listaProductos = this.productoService.getAll();
		if(listaProductos == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listaProductos);
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> getById(@PathVariable("id") Long id) {
		Producto producto = this.productoService.getById(id);
		if(producto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(producto);
	}
	
	@PostMapping("/producto")
	public ResponseEntity<Producto> create(@RequestBody Producto producto) {
		Producto createProducto = this.productoService.create(producto);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentContextPath()
							.path("/id")
							.buildAndExpand(createProducto.getId())
							.toUri();
		
		return ResponseEntity.created(location).body(createProducto);
	}
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<Producto> update(@PathVariable("id") Long id,@RequestBody Producto producto) {
		Producto updateProducto = this.productoService.getById(id);
		if(updateProducto == null) {
			return ResponseEntity.notFound().build();
		}
		
		updateProducto.setName(producto.getName());
		this.productoService.create(updateProducto);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.build()
							.toUri();
		
		return ResponseEntity.created(location).body(producto);
	}
	
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<Producto> delete(@PathVariable("id") Long id) {
		if(this.productoService.getById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		
		this.productoService.delete(id);
		
		return ResponseEntity.ok().build();
			
	}

}
