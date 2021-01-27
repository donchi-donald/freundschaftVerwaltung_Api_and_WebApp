package com.leprincedoni.webapp.controller;

import com.leprincedoni.webapp.model.Freund;
import com.leprincedoni.webapp.service.FreundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.Data;

@Data
@Controller
public class FreundController {

	@Autowired
	private FreundService service;
	
	@GetMapping("/")
	public String home(Model model) {//Spring se charge de nous fournir une instance de cet object
		Iterable<Freund> listFreund = service.getFreunde();
		model.addAttribute("freunde", listFreund);//j ajoute a mon model un object(le nom de mon choix, et la liste des employes en Iterable)
		return "home";
	}
	
	@GetMapping("/createFreund")
	public String createFreund(Model model) {
		Freund e = new Freund();
		model.addAttribute("freund", e);
		return "formNewFreund";
	}
	
	@GetMapping("/updateFreund/{id}")
	public String updateFreund(@PathVariable("id") final int id, Model model) {
		Freund e = service.getFreund(id);
		model.addAttribute("freund", e);
		return "formUpdateFreund";
	}

	/**
	 * La méthode deleteFreund possède un paramètre nommé id de type int ;
	 * cependant le point clé est l’annotation @PathVariable qui signifie que ce paramètre est présent dans l’URL de requête
	 * (par exemple http://localhost:9001/deleteFreund/1). Je peux ensuite me servir de la variable id dans le code : service.deleteFreund(id);
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteFreund/{id}")
	public ModelAndView deleteFreund(@PathVariable("id") final int id) {
		service.deleteFreund(id);
		return new ModelAndView("redirect:/");		
	}

	/**
	 * La méthode saveFreund est annotée @PostMapping et non @GetMapping. Effectivement, il s’agit ici de traiter la validation d’un formulaire,
	 * et généralement les formulaires exécutent des requêtes POST.
	 *
	 * L’autre point clé est le paramètre de la méthode “@ModelAttribute Freund freund”.
	 * @ModelAttribute est l’annotation magique.
	 * Cette annotation permet à Spring de récupérer les données saisies dans les champs du formulaire et de construire un objet Freund avec.
	 * @param freund
	 * @return
	 */
	@PostMapping("/saveFreund")
	public ModelAndView saveFreund(@ModelAttribute Freund freund) {
		if(freund.getId() != null) {
			// Freund from update form has the password field not filled,
			// so we fill it with the current password.
			Freund current = service.getFreund(freund.getId());
			freund.setPassword(current.getPassword());
		}
		service.saveFreund(freund);
		return new ModelAndView("redirect:/");	
	}
	
}
