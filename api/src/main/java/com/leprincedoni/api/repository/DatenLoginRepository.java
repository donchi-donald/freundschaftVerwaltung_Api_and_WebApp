package com.leprincedoni.api.repository;

import com.leprincedoni.api.model.DatenLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatenLoginRepository extends CrudRepository<DatenLogin, String> {
}
