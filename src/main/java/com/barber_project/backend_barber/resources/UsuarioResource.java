package com.barber_project.backend_barber.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.barber_project.backend_barber.entities.Usuario;
import com.barber_project.backend_barber.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;	
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		obj = service.insert(obj);	
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
