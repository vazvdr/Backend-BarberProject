package com.barber_project.backend_barber.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.barber_project.backend_barber.entities.Usuario;
import com.barber_project.backend_barber.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario insert(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuario) {
        Usuario existingUser = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        existingUser.setNome(usuario.getNome());
        existingUser.setEmail(usuario.getEmail());
        existingUser.setTelefone(usuario.getTelefone());
        
        if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
            existingUser.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }
        
        return repository.save(existingUser);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
