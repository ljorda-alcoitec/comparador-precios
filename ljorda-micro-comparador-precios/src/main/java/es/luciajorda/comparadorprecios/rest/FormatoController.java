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

import es.luciajorda.comparadorprecios.domain.Formato;
import es.luciajorda.comparadorprecios.service.FormatoService;

@RestController
public class FormatoController {
	
	@Autowired FormatoService formatoService;
	
	@GetMapping("/formato")
	public ResponseEntity<List<Formato>> getAll(){
		List<Formato> listaFormatos = this.formatoService.getAll();
		if(listaFormatos == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listaFormatos);
	}
	
	@GetMapping("/formato/{id}")
	public ResponseEntity<Formato> getById(@PathVariable("id") long id){
		Formato formato = this.formatoService.getById(id);
		if (formato == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(formato);
	}
	
	@PostMapping("/formato")
	public ResponseEntity<Formato> create(@RequestBody Formato formato){
		Formato createFormato = this.formatoService.create(formato);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentContextPath()
							.path("/id")
							.buildAndExpand(createFormato.getId())
							.toUri();
		
		return ResponseEntity.created(location).body(createFormato);
	}
	
	@PutMapping("/formato/{id}")
	public ResponseEntity<Formato> update(@RequestBody Formato formato, @PathVariable("id") long id){
		Formato updateFormato = this.formatoService.getById(id);
		if(updateFormato == null) {
			return ResponseEntity.notFound().build();
		}
		
		updateFormato.setCantidad(formato.getCantidad());
		updateFormato.setUnidad(formato.getUnidad());
		updateFormato.setUnidades(formato.getUnidades());
		this.formatoService.create(updateFormato);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.build()
							.toUri();
		
		return ResponseEntity.ok().body(updateFormato);
	}
	
	@DeleteMapping("/formato/{id}")
	public ResponseEntity<Formato> delete(@PathVariable("id") long id){
		if(this.formatoService.getById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		
		this.formatoService.delete(id);
		
		return ResponseEntity.ok().build();
	}
}
