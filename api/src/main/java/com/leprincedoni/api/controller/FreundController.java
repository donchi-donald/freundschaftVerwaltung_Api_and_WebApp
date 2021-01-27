package com.leprincedoni.api.controller;

import java.util.Optional;

import com.leprincedoni.api.service.FreundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leprincedoni.api.model.Freund;

@RestController
public class FreundController {
	
	@Autowired //j injecte une instance de FreundService nomme freundservice
	private FreundService freundService;
	
	/**
	 * Create - Add a new freund
	 * @param freund An object employee
	 * @return The employee object saved
	 */
	@PostMapping("/freund")
	public Freund createFreund(@RequestBody Freund freund) {
		return freundService.saveFreund(freund);
	}
	
	
	/**
	 * Read - Get one freund
	 * @param id The id of the freund
	 * @return An freund object full filled
	 */
	@GetMapping("/freund/{id}")
	public Freund getFreund(@PathVariable("id") final Long id) {
		Optional<Freund> freund = freundService.getFreund(id);
		if(freund.isPresent()) {
			return freund.get();
		} else {
			return null;
		}
	}

	
	/**
	 * Read - Get all friends
	 * @return - An Iterable object of friend full filled
	 */
	@GetMapping("/freunde")
	public Iterable<Freund> getFreunde() {
		return freundService.getFreunde();
	}
	
	/**
	 * Update - Update an existing friend
	 * @param id - The id of the friend to update
	 * @param freund - The friend object updated
	 * @return
	 */
	@PutMapping("/freund/{id}")
	public Freund updateFreund(@PathVariable("id") final Long id, @RequestBody Freund freund) {
		Optional<Freund> e = freundService.getFreund(id);
		if(e.isPresent()) {
			Freund currentFreund = e.get();
			
			String firstName = freund.getFirstName();
			if(firstName != null) {
				currentFreund.setFirstName(firstName);
			}
			String lastName = freund.getLastName();
			if(lastName != null) {
				currentFreund.setLastName(lastName);;
			}
			String mail = freund.getMail();
			if(mail != null) {
				currentFreund.setMail(mail);
			}
			String password = freund.getPassword();
			if(password != null) {
				currentFreund.setPassword(password);;
			}
			freundService.saveFreund(currentFreund);
			return currentFreund;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Delete an friend
	 * @param id - The id of the friend to delete
	 */
	@DeleteMapping("/freund/{id}")
	public void deleteFreund(@PathVariable("id") final Long id) {
		freundService.deleteFreund(id);
	}
	

}
