package com.generation.ClientFlow.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "tb_produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome da empresa é obrigatório!")
	@Size(max = 100, message = "O atributo nome da empresa tem que ser menor que 100 caracteres!")
	private String nome;
	
	@NotBlank(message = "O atributo segmento da empresa é obrigatório!")
	@Size(max = 100, message = "O atributo segmento da empresa tem que ser menor que 100 caracteres!")
	private String segmento;
	
	@NotBlank(message = "O atributo ponto focal é obrigatório!")
	@Size(max = 100, message = "O atributo ponto focal da empresa tem que ser menor que 100 caracteres!")
	private String pontoFocal;
	
	@NotNull(message = "O atributo valor do contrato é obrigatório!")
	private Float valorContrato;
	
	@ManyToOne 
	@JsonIgnoreProperties("produtos") 
	private Categoria categorias; 
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuario usuario;

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

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getPontoFocal() {
		return pontoFocal;
	}

	public void setPontoFocal(String pontoFocal) {
		this.pontoFocal = pontoFocal;
	}

	public Float getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(Float valorContrato) {
		this.valorContrato = valorContrato;
	}

	public Categoria getCategorias() {
		return categorias;
	}

	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
