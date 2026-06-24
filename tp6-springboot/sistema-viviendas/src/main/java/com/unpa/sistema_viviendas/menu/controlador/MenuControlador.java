package com.unpa.sistema_viviendas.menu.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuControlador {
    @GetMapping("/index")
        public String index(){
        return "index";
    }
}
