package com.leprincedoni.api.service;

import com.leprincedoni.api.model.DatenLogin;
import com.leprincedoni.api.repository.DatenLoginRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Data
@Service
public class DatenLoginService {

    @Autowired
    private DatenLoginRepository datenLoginRepository;

    public Iterable<DatenLogin> getDatenLogin(){
        return datenLoginRepository.findAll();
    }

}
