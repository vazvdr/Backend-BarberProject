package com.barber_project.backend_barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber_project.backend_barber.entities.Profissional;
import com.barber_project.backend_barber.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repository;
	
	public List<Profissional>findAll (){
		return repository.findAll();
	}
	
	public Profissional findById(Long id) {
		Optional<Profissional> obj = repository.findById(id);
		return obj.get();
	}

}
