package com.barber_project.backend_barber.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber_project.backend_barber.dto.LoginRequest;
import com.barber_project.backend_barber.entities.Usuario;
import com.barber_project.backend_barber.repositories.UsuarioRepository;
import com.barber_project.backend_barber.services.UsuarioService;
import com.barber_project.backend_barber.util.JwtUtil;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository repository;
    
    @Autowired
    private UsuarioService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Usuario> userOptional = repository.findByEmail(loginRequest.getEmail());

        if (userOptional.isPresent()) {
            Usuario usuario = userOptional.get();

            // Verifica se a senha fornecida corresponde à senha armazenada (criptografada)
            if (passwordEncoder.matches(loginRequest.getSenha(), usuario.getSenha())) {
                // Gera um token JWT
                String token = jwtUtil.generateToken(usuario.getEmail());

                return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
            }
        }

        return ResponseEntity.status(401).body("{\"error\": \"Email ou senha inválidos\"}");
    }
    
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