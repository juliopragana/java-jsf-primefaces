package com.app.jum.repository;

import java.io.Serializable;
import java.util.List;

import com.app.jum.models.Pessoa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class Pessoas implements Serializable {

	private static final long serialVersionUID = 4676162994844527977L;
	
	private EntityManager manager;
	
	public Pessoas() {
	    // Construtor padrão necessário
	}
	
	@Inject
	public Pessoas(EntityManager manager) {
		this.manager = manager;
	}
	
	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> todas(){
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}

}
