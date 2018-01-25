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

import es.luciajorda.comparadorprecios.domain.Variedad;
import es.luciajorda.comparadorprecios.service.VariedadService;

@RestController
public class VariedadController {

	@Autowired VariedadService variedadService;
	
	@GetMapping("/variedad")
	public ResponseEntity<List<Variedad>> getAll(){
		List<Variedad> listaVariedades = this.variedadService.getAll();
		if(listaVariedades == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listaVariedades);
	}
	
	@GetMapping("/variedad/{id}")
	public ResponseEntity<Variedad> getById(@PathVariable("id") long id){
		Variedad variedad = this.variedadService.getById(id);
		if(variedad == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(variedad);
	}
	
	@PostMapping("/variedad")
	public ResponseEntity<Variedad> create(@RequestBody Variedad variedad){
		Variedad createVariedad = this.variedadService.create(variedad);
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentContextPath()
						.path("/id")
						.buildAndExpand(createVariedad.getId())
						.toUri();
		
		return ResponseEntity.created(location).body(createVariedad);
	}
	
	@PutMapping("/variedad/{id}")
	public ResponseEntity<Variedad> update(@RequestBody Variedad variedad, @PathVariable("id") long id){
		Variedad updateVariedad = this.variedadService.getById(id);
		
		if (updateVariedad == null) {
			return ResponseEntity.notFound().build();
		}
		
		updateVariedad.setIdProducto(variedad.getIdProducto());
		updateVariedad.setIdFormato(variedad.getIdFormato());
		this.variedadService.create(updateVariedad);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.build()
							.toUri();
		return ResponseEntity.created(location).body(updateVariedad);
	}
	
	@DeleteMapping("/variedad/{id}")
	public ResponseEntity<Variedad> delete(@PathVariable("id") long id){
		if(this.variedadService.getById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		this.variedadService.delete(id);
		return ResponseEntity.ok().build();
	}	
}
