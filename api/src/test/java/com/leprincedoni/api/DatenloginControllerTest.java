package com.leprincedoni.api;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DatenloginControllerTest {

    @Autowired
    public MockMvc mockMvc;

    //$ pointe sur la racine de la structure json $[0] premier element de la liste
    @Test
    public void testGetDatenLogin() throws  Exception{
        mockMvc.perform(get("/datenlogin")).andExpect(
                status().isOk())
                .andExpect(jsonPath("$[0].username", is("doni")))
                .andExpect(jsonPath("$[0].passwort", is("1234"))
        );
    }
}
