package com.app.jum.controller.lancamentos;

import java.io.Serializable;
import java.util.List;

import com.app.jum.models.Lancamento;
import com.app.jum.repository.Lancamentos;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ConsultaLancamentosBean implements Serializable{

	private static final long serialVersionUID = 7747669840914819002L;
	
	@Inject
	private Lancamentos lancamentosRepository;
	
	private List<Lancamento> lancamentos;
	
	public void consultar() {
		this.lancamentos = lancamentosRepository.todos();
	}
	
	public List<Lancamento> getLancamentos(){
		return lancamentos;
	}

}
