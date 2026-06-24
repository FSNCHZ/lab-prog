package com.unpa.sistema_viviendas.barrios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unpa.sistema_viviendas.barrios.servicio.BarrioServicio;
import com.unpa.sistema_viviendas.barrios.modelo.BarrioModelo;

@Controller
@RequestMapping("/barrios")
public class BarrioControlador {
    @Autowired
    private BarrioServicio servicio;

    @GetMapping
    public String listarBarrios(Model modelo){
        List<BarrioModelo> barrio = servicio.listar();
        modelo.addAttribute("barrios", barrio);
        return "barrios";
    }

    @GetMapping("/nuevo")
    public String registrarBarrio(Model modelo){
        BarrioModelo barrio = new BarrioModelo();
        modelo.addAttribute("barrio", barrio);
        return "barrio-crear";
    }

    @PostMapping
    public String guardarBarrio(@ModelAttribute("vivienda") BarrioModelo barrio){
        servicio.guardarBarrio(barrio);
        return "redirect:/barrios";
    }

    @GetMapping("/{id}")
    public String eliminarBarrio(@PathVariable int id){
        servicio.eliminarBarrio(id);
        return "redirect:/barrios";
    }
}
