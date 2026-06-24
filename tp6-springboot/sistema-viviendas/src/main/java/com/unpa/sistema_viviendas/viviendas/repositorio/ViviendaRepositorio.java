package com.unpa.sistema_viviendas.viviendas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unpa.sistema_viviendas.viviendas.modelo.ViviendaModelo;

@Repository
public interface ViviendaRepositorio extends JpaRepository<ViviendaModelo, Integer>{
    
}
