package es.luciajorda.comparadorprecios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.luciajorda.comparadorprecios.domain.Formato;
import es.luciajorda.comparadorprecios.repository.FormatoRepository;

@Service
public class FormatoService {
	
	@Autowired FormatoRepository formatoRepository;
	
	public FormatoService() {}
	
	public Formato create(Formato formato) {
		return this.formatoRepository.save(formato);
	}
	
	public void update(Formato formato) {
		this.formatoRepository.save(formato);
	}
	
	public void delete(long id) {
		this.formatoRepository.delete(id);
	}
	
	public Formato getById(long id) {
		return this.formatoRepository.findOne(id);
	}
	
	public List<Formato> getAll(){
		return (List<Formato>) this.formatoRepository.findAll();
	}

}
