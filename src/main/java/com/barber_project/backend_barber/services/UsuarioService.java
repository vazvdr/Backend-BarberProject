package com.barber_project.backend_barber.services;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.barber_project.backend_barber.entities.Usuario;
import com.barber_project.backend_barber.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario insert(Usuario usuario) {
        if (usuario.isBarbeiro()) {
            throw new ResponseStatusException(FORBIDDEN, "Não é permitido cadastrar-se como barbeiro.");
        }
        
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }


    public Usuario login(String email, String senha) {
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário não encontrado"));

        if (!passwordEncoder.matches(senha, usuario.getSenha())) {
            throw new ResponseStatusException(FORBIDDEN, "Senha ou email incorretos!");
        }

        return usuario;
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
