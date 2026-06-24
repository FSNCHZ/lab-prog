package com.unpa.sistema_viviendas.barrios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unpa.sistema_viviendas.barrios.modelo.BarrioModelo;
import com.unpa.sistema_viviendas.barrios.repositorio.BarrioRepositorio;

@Service
public class BarrioServicio implements BarrioServicioInterface{
    @Autowired
    private BarrioRepositorio repositorio;

    @Override
    public List<BarrioModelo> listar(){
        return repositorio.findAll();
    }

    @Override
    public BarrioModelo guardarBarrio(BarrioModelo barrio){
        return repositorio.save(barrio);
    }

    @Override
    public void eliminarBarrio(int id){
        repositorio.deleteById(id);
    }
}
