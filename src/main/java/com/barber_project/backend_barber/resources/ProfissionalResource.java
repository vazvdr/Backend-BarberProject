package com.barber_project.backend_barber.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber_project.backend_barber.entities.Profissional;
import com.barber_project.backend_barber.services.ProfissionalService;

@RestController
@RequestMapping(value = "/profissionais")
public class ProfissionalResource {
	
	@Autowired
	private ProfissionalService service;	
	
	@GetMapping
	public ResponseEntity<List<Profissional>> findAll () {
		List<Profissional> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Profissional> findById(@PathVariable Long id) {
		Profissional obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
