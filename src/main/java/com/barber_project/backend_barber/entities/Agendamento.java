package com.barber_project.backend_barber.entities;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_agendamentos",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"data", "profissionalId"})
    }
)
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Instant data;

    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "profissionalId", nullable = false)
    private Profissional profissional;

    @ManyToMany
    @JoinTable(
        name = "agendamento_servico",
        joinColumns = @JoinColumn(name = "agendamentoId"),
        inverseJoinColumns = @JoinColumn(name = "servicoId")
    )
    private Set<Servico> servico;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Set<Servico> getServicos() {
        return servico;
    }

    public void setServicos(Set<Servico> servico) {
        this.servico = servico;
    }
}

