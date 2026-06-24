package com.unpa.sistema_viviendas.viviendas.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unpa.sistema_viviendas.viviendas.modelo.ViviendaModelo;
import com.unpa.sistema_viviendas.viviendas.repositorio.ViviendaRepositorio;

@Service
public class ViviendaServicio implements ViviendaServicioInterface{
    @Autowired
    private ViviendaRepositorio repositorio;

    @Override
    public List<ViviendaModelo> listar(){
        return repositorio.findAll();
    }

    @Override
    public ViviendaModelo guardarVivienda(ViviendaModelo vivienda){
        return repositorio.save(vivienda);
    }

    @Override
    public ViviendaModelo obtenerViviendaPorId(int id){
        return repositorio.findById(id).get();
    }

    @Override
    public ViviendaModelo actualizarVivienda(ViviendaModelo vivienda){
        return repositorio.save(vivienda);
    }

    @Override
    public void eliminarVivienda(int id){
        repositorio.deleteById(id);
    }
}
