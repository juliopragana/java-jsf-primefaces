package com.app.jum.converter;

import com.app.jum.models.Pessoa;
import com.app.jum.repository.Pessoas;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter{

	@Inject // funciona graças ao OmniFaces
	private Pessoas pessoas;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.trim().isEmpty()) {
			return null;
		}
		try {
			Long id = Long.parseLong(value);
			return this.pessoas.porId(id);
		} catch (Exception e) {
			throw new ConverterException("ID da Pessoa inválido: " + value, e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Pessoa) value).getId().toString();
		}
		return null;
	}

}
