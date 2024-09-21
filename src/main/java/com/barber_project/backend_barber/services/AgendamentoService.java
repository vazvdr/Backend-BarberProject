package com.barber_project.backend_barber.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barber_project.backend_barber.dto.AgendamentoRequest;
import com.barber_project.backend_barber.entities.Agendamento;
import com.barber_project.backend_barber.entities.Profissional;
import com.barber_project.backend_barber.entities.Servico;
import com.barber_project.backend_barber.entities.Usuario;
import com.barber_project.backend_barber.repositories.AgendamentoRepository;
import com.barber_project.backend_barber.repositories.ProfissionalRepository;
import com.barber_project.backend_barber.repositories.ServicoRepository;
import com.barber_project.backend_barber.repositories.UsuarioRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Transactional
    public Agendamento criarAgendamento(AgendamentoRequest agendamentoDTO) {
        // Buscar o usuário
        Usuario usuario = usuarioRepository.findById(agendamentoDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Buscar o profissional
        Profissional profissional = profissionalRepository.findById(agendamentoDTO.getProfissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        // Buscar os serviços
        Set<Servico> servicos = new HashSet<>();
        for (Long servicoId : agendamentoDTO.getServicoIds()) {
            Servico servico = servicoRepository.findById(servicoId)
                    .orElseThrow(() -> new RuntimeException("Serviço com ID " + servicoId + " não encontrado"));
            servicos.add(servico);
        }

        // Criar o agendamento
        Agendamento agendamento = new Agendamento();
        agendamento.setData(agendamentoDTO.getData());
        agendamento.setUsuario(usuario);
        agendamento.setProfissional(profissional);
        agendamento.setServicos(servicos);

        // Salvar no banco de dados
        return agendamentoRepository.save(agendamento);
    }

    // Método para pegar agendamento por ID
    public Agendamento getAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento com ID " + id + " não encontrado"));
    }

    // Método para atualizar um agendamento
    @Transactional
    public Agendamento atualizarAgendamento(Long id, AgendamentoRequest agendamentoDTO) {
        Agendamento agendamentoExistente = getAgendamentoPorId(id);

        // Buscar o usuário
        Usuario usuario = usuarioRepository.findById(agendamentoDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Buscar o profissional
        Profissional profissional = profissionalRepository.findById(agendamentoDTO.getProfissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        // Buscar os serviços
        Set<Servico> servicos = new HashSet<>();
        for (Long servicoId : agendamentoDTO.getServicoIds()) {
            Servico servico = servicoRepository.findById(servicoId)
                    .orElseThrow(() -> new RuntimeException("Serviço com ID " + servicoId + " não encontrado"));
            servicos.add(servico);
        }

        // Atualizar os dados do agendamento
        agendamentoExistente.setData(agendamentoDTO.getData());
        agendamentoExistente.setUsuario(usuario);
        agendamentoExistente.setProfissional(profissional);
        agendamentoExistente.setServicos(servicos);

        // Salvar as alterações no banco de dados
        return agendamentoRepository.save(agendamentoExistente);
    }
}
