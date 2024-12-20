package com.app.jum.controller.lancamentos;

import java.io.Serializable;
import java.util.List;

import com.app.jum.enums.TipoLancamento;
import com.app.jum.models.Lancamento;
import com.app.jum.models.Pessoa;
import com.app.jum.repository.Pessoas;
import com.app.jum.service.CadastroLancamentos;
import com.app.jum.service.NegocioException;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = -2942962279064588837L;
	
	@Inject
	private CadastroLancamentos cadastro;
	
	@Inject
	private Pessoas pessoas;
	
	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> todasPessoas;
	
	public void prepararCadastro() {
		this.todasPessoas = pessoas.todas();
	}
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			this.cadastro.salvar(lancamento);
			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage(
					"Lançamento salvo com sucesso!"));
						
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}	
		
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<Pessoa> getTodasPessoas() {
		return todasPessoas;
	}

	public void setTodasPessoas(List<Pessoa> todasPessoas) {
		this.todasPessoas = todasPessoas;
	}
	
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}	


}
