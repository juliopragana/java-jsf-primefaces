package com.app.jum.repository;

import java.io.Serializable;
import java.util.List;

import com.app.jum.models.Lancamento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class Lancamentos implements Serializable{

	private static final long serialVersionUID = 2295654482096026847L;
	
	private EntityManager manager;
	
	// Construtor padrão (sem argumentos)
    public Lancamentos() {
    }
	
	@Inject
	public Lancamentos(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Lancamento> todos(){
		TypedQuery<Lancamento> query = manager.createQuery("from Lancamento", Lancamento.class);
		return query.getResultList();
	}
	
	public void adicionar(Lancamento lancamento) {
		this.manager.persist(lancamento);
	}

}
