package com.leprincedoni.webapp;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest //permet au contexte Spring d etre charge lors de l execution des tests
@AutoConfigureMockMvc
public class FreundControllerTest {

	@Autowired
	private MockMvc mockMvc;//afin d executer une requete au controlleur
	
	@Test
	public void testGetFreunde() throws Exception {
		
		mockMvc.perform(get("/"))
			.andDo(print())
			.andExpect(status().isOk()) //reponse 200
			.andExpect(view().name("home")) //le nom de vue retourne correspomd au parametre home
			.andExpect(content().string(containsString("Winnie")));//le corp de la mezhode contient a un moment le texte Donald
		
	}
	
}
