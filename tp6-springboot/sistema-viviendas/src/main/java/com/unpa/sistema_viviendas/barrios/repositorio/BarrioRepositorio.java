package com.unpa.sistema_viviendas.barrios.repositorio;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.unpa.sistema_viviendas.barrios.modelo.BarrioModelo;

@Repository
public interface BarrioRepositorio extends JpaRepository<BarrioModelo, Integer>{
    
}
