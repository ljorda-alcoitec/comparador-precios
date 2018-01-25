package es.luciajorda.comparadorprecios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.luciajorda.comparadorprecios.domain.Variedad;
import es.luciajorda.comparadorprecios.repository.VariedadRepository;

@Service
public class VariedadService {

	@Autowired VariedadRepository variedadRepository;
	
	public Variedad create(Variedad variedad) {
		return this.variedadRepository.save(variedad);
	}
	
	public void update(Variedad variedad) {
		this.variedadRepository.save(variedad);
	}
	
	public void delete(long id) {
		this.variedadRepository.delete(id);
	}
	
	public Variedad getById(long id) {
		return this.variedadRepository.findOne(id);
	}
}
