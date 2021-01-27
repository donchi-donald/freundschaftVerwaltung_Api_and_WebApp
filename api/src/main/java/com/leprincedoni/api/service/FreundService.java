package com.leprincedoni.api.service;

import java.util.Optional;

import com.leprincedoni.api.model.Freund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leprincedoni.api.repository.FreundRepository;

import lombok.Data;

@Data
@Service
public class FreundService {
	
	@Autowired
	private FreundRepository freundRepository;
	
	public Optional<Freund> getFreund(final Long id) {

		return freundRepository.findById(id);
	}
	
	public Iterable<Freund> getFreunde() {
		return freundRepository.findAll();
	}
	
	public void deleteFreund(final Long id) {
		freundRepository.deleteById(id);
	}
	
	public Freund saveFreund(Freund freund) {
		Freund savedFreund = freundRepository.save(freund);
		return savedFreund;
	}

}
