package com.barber_project.backend_barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber_project.backend_barber.entities.Servico;
import com.barber_project.backend_barber.entities.Usuario;
import com.barber_project.backend_barber.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;
	
	public List<Servico>findAll (){
		return repository.findAll();
	}
	
	public Servico findById(Long id) {
		Optional<Servico> obj = repository.findById(id);
		return obj.get();
	}
	
	public Servico insert(Servico obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
