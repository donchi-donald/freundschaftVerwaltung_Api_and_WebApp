package com.leprincedoni.api.controller;

import com.leprincedoni.api.model.DatenLogin;
import com.leprincedoni.api.service.DatenLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1- coe component permet d indiquer a spring que classe est un bean
 * 2- Elle indique a Spring d inserer le retour de la methode au format
 * JSON dans le corps de la reponse HTTP. Grace a ce deuxieme point, les
 * applications qui vont communiquer avec ntre api accederont au resultat de leur requete en
 * passant la reponse http
 */
@RestController
public class DatenLoginController {

    @Autowired //j ai injecter une instance de Datenloginservice pour communiquer avec la base de donne
    private DatenLoginService datenLoginService;

    @GetMapping("/datenlogin")
    public Iterable<DatenLogin> getDatenLogin(){
        return datenLoginService.getDatenLogin();
    }

}
