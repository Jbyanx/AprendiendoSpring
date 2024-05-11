package org.bycompany.web;

import lombok.extern.slf4j.Slf4j;
import org.bycompany.dao.PersonaDao;
import org.bycompany.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {
    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/")
    public String inicio(Model model){
        var personasList = personaDao.findAll();

        log.info("ejecutando el controlador spring MVC");
        model.addAttribute("personas", personasList);

        return "index";
    }

}
