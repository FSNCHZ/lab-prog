package com.unpa.sistema_viviendas.viviendas.controlador;

import com.unpa.sistema_viviendas.barrios.servicio.BarrioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.unpa.sistema_viviendas.viviendas.servicio.ViviendaServicio;
import com.unpa.sistema_viviendas.viviendas.modelo.ViviendaModelo;

@Controller
@RequestMapping("/viviendas")
public class ViviendaControlador {
    private final BarrioServicio barrioServicio;
    @Autowired
    private ViviendaServicio servicio;

    ViviendaControlador(BarrioServicio barrioServicio) {
        this.barrioServicio = barrioServicio;
    }

    @GetMapping
    public String listarViviendas(Model modelo){
        List<ViviendaModelo> viviendas = servicio.listar();
        modelo.addAttribute("viviendas", viviendas);
        return "viviendas";
    }

    @GetMapping("/nueva")
    public String registrarVivienda(Model modelo){
        ViviendaModelo vivienda = new ViviendaModelo();
        modelo.addAttribute("vivienda", vivienda);
        modelo.addAttribute("barrios", barrioServicio.listar());
        return "vivienda-crear";
    }

    @PostMapping
    public String guardarVivienda(@ModelAttribute("vivienda") ViviendaModelo vivienda){
        servicio.guardarVivienda(vivienda);
        return "redirect:/viviendas";
    }

    @GetMapping("/editar/{id}")
    public String editarVivienda(@PathVariable int id, Model modelo){
        modelo.addAttribute("vivienda", servicio.obtenerViviendaPorId(id));
        modelo.addAttribute("barrios", barrioServicio.listar());
        return "editar";
    }

    @PostMapping("/{id}")
    public String actualizarVivienda(@PathVariable int id, @ModelAttribute("vivienda") ViviendaModelo vivienda, Model modelo){
        ViviendaModelo viviendaExistente = servicio.obtenerViviendaPorId(id);
        viviendaExistente.setId(id);
        viviendaExistente.setCalle(vivienda.getCalle());
        viviendaExistente.setNro(vivienda.getNro());
        viviendaExistente.setTitular(vivienda.getTitular());
        viviendaExistente.setNumHabitantes(vivienda.getNumHabitantes());
        viviendaExistente.setBarrio(vivienda.getBarrio());
        servicio.actualizarVivienda(viviendaExistente);
        return "redirect:/viviendas";
    }

    @GetMapping("/{id}")
    public String eliminarVivienda(@PathVariable int id){
        servicio.eliminarVivienda(id);
        return "redirect:/viviendas";
    }
}
