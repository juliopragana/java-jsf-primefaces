package com.app.jum.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.app.jum.enums.TipoLancamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1822013475937649536L;

	private Long id;
	private Pessoa pessoa;
	private String descricao;
	private BigDecimal valor;
	private TipoLancamento tipo;
	private Date dataVencimento;
	private Date dataPagamento;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name="pessoa_id")
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@NotEmpty
	@Size(max = 190)
	@Column(length = 190, nullable = false)	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@NotNull
	@DecimalMin("0")
	@Column(precision = 10, scale=2, nullable = false)
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TipoLancamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}
	
	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_pagamento", nullable = false)
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
}
