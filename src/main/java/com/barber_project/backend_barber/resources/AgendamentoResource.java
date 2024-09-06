package com.barber_project.backend_barber.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber_project.backend_barber.entities.Agendamento;
import com.barber_project.backend_barber.entities.Usuario;
import com.barber_project.backend_barber.services.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResource {
	
	@Autowired
	private AgendamentoService service;	
	
	@GetMapping
	public ResponseEntity<List<Agendamento>> findAll () {
		List<Agendamento> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	} // metodo que recupera todos os agendamentos
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Agendamento> findById(@PathVariable Long id) {
		Agendamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	} //metodo que recupera um agendamento pelo id dele
	
	@PostMapping
	public ResponseEntity<Agendamento> insert(@RequestBody Agendamento obj){
		obj = service.insert(obj);	
		return ResponseEntity.ok().body(obj);
	} //metodo que faz um agendamento
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();	
	} //metodo que cancela um agendamento
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Agendamento> update(@PathVariable Long id, @RequestBody Agendamento obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	} //metodo que altera um agendamento, observe o metodo update na classe agendamento service

}
