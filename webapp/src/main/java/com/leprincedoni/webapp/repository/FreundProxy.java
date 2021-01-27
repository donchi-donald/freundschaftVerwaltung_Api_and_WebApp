package com.leprincedoni.webapp.repository;

import com.leprincedoni.webapp.CustomProperties;
import com.leprincedoni.webapp.model.Freund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FreundProxy {

	@Autowired
	private CustomProperties props;

	/**
	 * Get all Freunde
	 * @return An iterable of all friends
	 */
	public Iterable<Freund> getFreunde() {

		String baseApiUrl = props.getApiUrl(); //l adresse url de l app on recupere
		String getFreundeUrl = baseApiUrl + "/freunde"; //on complete l url de l api par le path de l endpoint a joindre

		RestTemplate restTemplate = new RestTemplate(); //on instancie ntre object RestTemplate
		ResponseEntity<Iterable<Freund>> response = restTemplate.exchange(
				getFreundeUrl,
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Freund>>() {}
			);//on appele la methode exchange en transmettant l url, la methode http, le type retour ParameterizedTypeReference car /employes renvoie un object Iterable<Freund>
		
		log.debug("Get Friend call " + response.getStatusCode().toString());
		
		return response.getBody(); //on recupere ntre object Iterable<Freund> grace a getBody()
	}
	
	/**
	 * Get an friend by the id
	 * @param id The id of the friend
	 * @return The friend which matches the id
	 */
	public Freund getFreund(int id) {
		String baseApiUrl = props.getApiUrl();
		String getFriendUrl = baseApiUrl + "/freund/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Freund> response = restTemplate.exchange(
				getFriendUrl,
				HttpMethod.GET, 
				null,
				Freund.class
			);
		
		log.debug("Get Freund call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Add a new Freund
	 * @param e A new Freund (without an id)
	 * @return The friend full filled (with an id)
	 */
	public Freund createFreund(Freund e) {
		String baseApiUrl = props.getApiUrl();
		String createFreundUrl = baseApiUrl + "/freund";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Freund> request = new HttpEntity<Freund>(e);
		ResponseEntity<Freund> response = restTemplate.exchange(
				createFreundUrl,
				HttpMethod.POST, 
				request, 
				Freund.class);
		
		log.debug("Create Freund call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Update an Friend - using the PUT HTTP Method.
	 * @param e Existing employee to update
	 */
	public Freund updateFreund(Freund e) {
		String baseApiUrl = props.getApiUrl();
		String updateFreundUrl = baseApiUrl + "/freund/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Freund> request = new HttpEntity<Freund>(e);
		ResponseEntity<Freund> response = restTemplate.exchange(
				updateFreundUrl,
				HttpMethod.PUT, 
				request, 
				Freund.class);
		
		log.debug("Update Freund call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Delete an friend using exchange method of RestTemplate
	 * instead of delete method in order to log the response status code.
	 * @param id The friend to delete
	 */
	public void deleteFreund(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteFriendUrl = baseApiUrl + "/freund/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteFriendUrl,
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete Freund call " + response.getStatusCode().toString());
	}

}
