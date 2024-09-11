package com.barber_project.backend_barber.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_profissional")
public class Profissional implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(unique = true)
    private String nome;
	private String descricao;
	private String imagemUrl;
	private Float avaliacao;
	private Integer qtdAvaliacoes;
	
	@OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;

	
	public Profissional() {
	}

	public Profissional(Long id, String nome, String descricao, String imagemUrl, float avaliacao,
			Integer qtdAvaliacoes) {
		super();
		this.id = id;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return Objects.hash(nome);
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
		return Objects.equals(nome, other.nome);
	}	
}
