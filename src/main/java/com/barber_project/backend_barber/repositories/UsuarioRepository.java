package com.barber_project.backend_barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber_project.backend_barber.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
