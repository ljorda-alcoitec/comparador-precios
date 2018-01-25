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
	
	public Producto create(Producto producto) {
		return this.productoRepository.save(producto);
	}
	
	public void update(Producto producto) {
		this.productoRepository.save(producto);
	}
	
	public void delete(long id) {
		this.productoRepository.delete(id);
	}
	
	public Producto getById(long id) {
		return this.productoRepository.findOne(id);
	}
	
	public List<Producto> getAll(){
		return (List<Producto>) this.productoRepository.findAll();
	}
	
	public Producto findByName(String name) {
		return this.productoRepository.findProductByName(name);
	}
}
