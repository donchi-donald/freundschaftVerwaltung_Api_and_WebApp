package com.leprincedoni.api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "datenlogin")
public class DatenLogin {

    @Id
    private String username;

    private String passwort;
}
