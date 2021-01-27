package com.leprincedoni.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leprincedoni.api.model.Freund;

/**
 * repository pour indiquer que la classe est un bean wie component
 * crudrepository fournit des methode pour manipuler ntre based de donne
 */
@Repository
public interface FreundRepository extends CrudRepository<Freund, Long>{

}
