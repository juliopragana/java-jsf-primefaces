package com.app.jum.controller;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OlaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sobrenome;
	private String nomeCompleto;
	
	
	public void dizerOla() {
		this.nomeCompleto = this.nome.toUpperCase() + " " + this.sobrenome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	

}
