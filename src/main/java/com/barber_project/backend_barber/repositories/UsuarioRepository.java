package com.barber_project.backend_barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.barber_project.backend_barber.entities.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
