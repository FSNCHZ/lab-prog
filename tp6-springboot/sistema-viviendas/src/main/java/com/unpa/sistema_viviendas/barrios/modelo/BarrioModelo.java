package com.unpa.sistema_viviendas.barrios.modelo;

import java.util.ArrayList;
import java.util.List;

import com.unpa.sistema_viviendas.viviendas.modelo.ViviendaModelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="barrios")
public class BarrioModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @OneToMany(mappedBy = "barrio", cascade = CascadeType.ALL)
    private List<ViviendaModelo> viviendas = new ArrayList<>();

    public BarrioModelo(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public BarrioModelo(){}

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void addVivienda(ViviendaModelo vivienda){
        viviendas.add(vivienda);
        vivienda.setBarrio(this);
    }
}
