package es.luciajorda.comparadorprecios.repostitory;

import org.springframework.data.repository.CrudRepository;

import es.luciajorda.comparadorprecios.domain.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	Producto findProductoByName(String name);
}
