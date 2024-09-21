package com.barber_project.backend_barber.dto;

import java.time.Instant;
import java.util.Set;

public class AgendamentoRequest {
    private Instant data;
    private Long usuarioId;
    private Long profissionalId;
    private Set<Long> servicoIds;

    // Getters e Setters
    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Set<Long> getServicoIds() {
        return servicoIds;
    }

    public void setServicoIds(Set<Long> servicoIds) {
        this.servicoIds = servicoIds;
    }
}
