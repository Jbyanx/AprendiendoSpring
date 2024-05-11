package org.bycompany.service;

import org.bycompany.dao.PersonaDao;
import org.bycompany.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService {
    @Autowired
    private PersonaDao personaDao;

    /**
     * Esta funcion llama al repositorio y trae las personas de la base de datos
     *
     * @return List<Persona> personas
     */
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    /**
     * Esta funcion guarda un objeto Persona en la base de datos
     *
     * @param persona Objeto del tipo Persona
     */
    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    /**
     * Esta funcion elimina un persona de la base de datos
     *
     * @param persona
     */
    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    /**
     * Esta funcion busca una persona en la base de datos
     *
     * @param persona Objeto del tipo Persona
     * @return Persona si existe en BD o null si no existe
     */
    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getId()).orElse(null);
    }
}
