package com.barber_project.backend_barber.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_profissional")
public class Profissional implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeProfissional;
	private String descricao;
	private String imagemUrl;
	private Float avaliacao;
	private Integer qtdAvaliacoes;
	
	@Transient
	private Set<Agendamento> agendamentos = new HashSet<>();
	
	public Profissional() {
	}

	public Profissional(Long id, String nomeProfissional, String descricao, String imagemUrl, float avaliacao,
			Integer qtdAvaliacoes) {
		super();
		this.id = id;
		this.nomeProfissional = nomeProfissional;
		this.descricao = descricao;
		this.imagemUrl = imagemUrl;
		this.avaliacao = avaliacao;
		this.qtdAvaliacoes = qtdAvaliacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProfissional() {
		return nomeProfissional;
	}

	public void setNome(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public Float getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Float avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Integer getQtdAvaliacoes() {
		return qtdAvaliacoes;
	}

	public void setQtdAvaliacoes(Integer qtdAvaliacoes) {
		this.qtdAvaliacoes = qtdAvaliacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomeProfissional);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		return Objects.equals(nomeProfissional, other.nomeProfissional);
	}	
}
