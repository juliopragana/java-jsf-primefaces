package com.app.jum.service;

import java.io.Serializable;
import java.util.Date;

import com.app.jum.models.Lancamento;
import com.app.jum.repository.Lancamentos;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CadastroLancamentos implements Serializable {

	private static final long serialVersionUID = -9196726590488900343L;
	
	@Inject
	private Lancamentos lancamentos;
	
	@PostConstruct
	public void init() {
	    System.out.println("CadastroLancamentos inicializado pelo CDI");
	}
	
	@Transactional
	public void salvar(Lancamento lancamento) throws NegocioException{
		if(lancamento.getDataPagamento() != null && lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");			
		}
		this.lancamentos.adicionar(lancamento);
	}


}
