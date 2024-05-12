package org.bycompany.web;

import lombok.extern.slf4j.Slf4j;
import org.bycompany.domain.Persona;
import org.bycompany.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ControladorInicio {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) {
        var personasList = personaService.listarPersonas();

        log.info("ejecutando el controlador spring MVC");
        model.addAttribute("personas", personasList);

        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
