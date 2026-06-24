package com.unpa.sistema_viviendas.viviendas.servicio;

import java.util.List;
import com.unpa.sistema_viviendas.viviendas.modelo.ViviendaModelo;

public interface ViviendaServicioInterface {
    public List<ViviendaModelo> listar();
    public ViviendaModelo guardarVivienda(ViviendaModelo vivienda);
    public ViviendaModelo obtenerViviendaPorId(int id);
    public ViviendaModelo actualizarVivienda(ViviendaModelo vivienda);
    public void eliminarVivienda(int id);
}
