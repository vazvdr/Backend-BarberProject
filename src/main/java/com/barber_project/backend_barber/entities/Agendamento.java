package com.barber_project.backend_barber.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_agendamento")
public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant data;
	private Integer profissionalId;
	private String servico;
	private String usuario;
	private Integer usuarioId;
	
	
	public Agendamento() {
	}

	public Agendamento(Long id, Instant data, Integer profissionalId, String servico, String usuario,
			Integer usuarioId) {
		super();
		this.id = id;
		this.data = data;
		this.profissionalId = profissionalId;
		this.servico = servico;
		this.usuario = usuario;
		this.usuarioId = usuarioId;
	}

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

	public Integer getProfissionalId() {
		return profissionalId;
	}

	public void setProfissionalId(Integer profissionalId) {
		this.profissionalId = profissionalId;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, profissionalId, servico, usuarioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		return Objects.equals(data, other.data) && Objects.equals(profissionalId, other.profissionalId)
				&& Objects.equals(servico, other.servico) && Objects.equals(usuarioId, other.usuarioId);
	}

}
