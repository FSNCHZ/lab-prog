package com.unpa.sistema_viviendas.barrios.servicio;

import java.util.List;

import com.unpa.sistema_viviendas.barrios.modelo.BarrioModelo;

public interface BarrioServicioInterface {
    public List<BarrioModelo> listar();
    public BarrioModelo guardarBarrio(BarrioModelo barrio);
    public void eliminarBarrio(int id);
}
