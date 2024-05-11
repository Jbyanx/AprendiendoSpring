package org.bycompany;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    @GetMapping("/")
    public String inicio(Model model){
        var saludar = "pasando objetos con thymeleaf";

        model.addAttribute("mensaje",saludar);
        model.addAttribute("saludo",saludo);
        log.info("ejecutando el controlador spring MVC");

        return "index";
    }

}
