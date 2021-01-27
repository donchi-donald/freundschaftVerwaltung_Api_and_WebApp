package com.leprincedoni.webapp.service;

import com.leprincedoni.webapp.model.Freund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprincedoni.webapp.repository.FreundProxy;

import lombok.Data;

@Data
@Service //point clee
public class FreundService {
	
	@Autowired
	private FreundProxy freundProxy; //employee proxy est injecte, cette phrase pourra faire appel a la source de donnees a travers le proxy
	
	public Freund getFreund(final int id) {
		return freundProxy.getFreund(id);
	}
	
	public Iterable<Freund> getFreunde() {
		return freundProxy.getFreunde();
	}
	
	public void deleteFreund(final int id) {
		freundProxy.deleteFreund(id);
	}
	
	public Freund saveFreund(Freund freund) {
		Freund savedFreund;
		
		// Functional rule : Last name must be capitalized.
		freund.setLastName(freund.getLastName().toUpperCase());

		if(freund.getId() == null) {
			// If id is null, then it is a new freund.
			savedFreund = freundProxy.createFreund(freund);
		} else {
			savedFreund = freundProxy.updateFreund(freund);
		}
		
		return savedFreund;
	}

}
