package com.barber_project.backend_barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber_project.backend_barber.entities.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {


}
