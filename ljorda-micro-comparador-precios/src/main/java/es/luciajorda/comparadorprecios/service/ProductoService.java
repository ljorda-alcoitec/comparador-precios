package es.luciajorda.comparadorprecios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.luciajorda.comparadorprecios.domain.Producto;
import es.luciajorda.comparadorprecios.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public ProductoService() {}
	
	public Producto createProducto(Producto producto) {
		return this.productoRepository.save(producto);
	}
	
	public Producto getProducto(long id) {
		return this.productoRepository.findOne(id);
	}
	
	public List<Producto> getAllProductos(){
		return (List<Producto>) this.productoRepository.findAll();
	}
	
	public Producto findProductoByName(String name) {
		return this.productoRepository.findProductoByName(name);
	}
	
	public void updateProducto(Producto producto) {
		this.productoRepository.save(producto);
	}
	
	public void deleteProducto(long id) {
		this.productoRepository.delete(id);
	}

}
