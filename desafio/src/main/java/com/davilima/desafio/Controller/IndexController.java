package com.davilima.desafio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("page", "index");
        model.addAttribute("titulo", "Principal");
        model.addAttribute("linkHome", "nav-item active");
        model.addAttribute("linkCliente", "nav-item");
        model.addAttribute("linkConteiner", "nav-item");
        return "base";
    }
}
