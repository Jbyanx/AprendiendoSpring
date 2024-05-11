package org.bycompany.dao;

import org.bycompany.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository< Persona, Integer> {

}
