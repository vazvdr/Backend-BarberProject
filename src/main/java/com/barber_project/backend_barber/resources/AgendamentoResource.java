package com.barber_project.backend_barber.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber_project.backend_barber.dto.AgendamentoRequest;
import com.barber_project.backend_barber.entities.Agendamento;
import com.barber_project.backend_barber.services.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResource {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody AgendamentoRequest agendamentoDTO) {
        Agendamento agendamento = agendamentoService.criarAgendamento(agendamentoDTO);
        return ResponseEntity.ok(agendamento);
    }
    
 // Endpoint para obter um agendamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> getAgendamentoPorId(@PathVariable Long id) {
        Agendamento agendamento = agendamentoService.getAgendamentoPorId(id);
        return ResponseEntity.ok(agendamento);
    }

    // Endpoint para atualizar um agendamento por ID
    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoRequest agendamentoDTO) {
        Agendamento agendamentoAtualizado = agendamentoService.atualizarAgendamento(id, agendamentoDTO);
        return ResponseEntity.ok(agendamentoAtualizado);
    }
}

