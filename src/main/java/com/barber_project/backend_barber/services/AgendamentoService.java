package com.barber_project.backend_barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber_project.backend_barber.entities.Agendamento;
import com.barber_project.backend_barber.entities.Usuario;
import com.barber_project.backend_barber.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;
	
	public List<Agendamento>findAll (){
		return repository.findAll();
	}
	
	public Agendamento findById(Long id) {
		Optional<Agendamento> obj = repository.findById(id);
		return obj.get();
	}
	
	public Agendamento insert(Agendamento obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Agendamento update(Long id, Agendamento obj) {
		Agendamento entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}

	private void updateData(Agendamento entity, Agendamento obj) {
		entity.setData(obj.getData());
		entity.setProfissionalId(obj.getProfissionalId());
		entity.setServico(obj.getServico());
	}

}
