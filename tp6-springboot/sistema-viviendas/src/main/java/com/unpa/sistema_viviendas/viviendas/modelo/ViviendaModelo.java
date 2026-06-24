package com.unpa.sistema_viviendas.viviendas.modelo;

import com.unpa.sistema_viviendas.barrios.modelo.BarrioModelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="viviendas")
public class ViviendaModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "calle", nullable = false, length = 50)
    private String calle;

    @Column(name= "nro", nullable = false, length = 5)
    private int nro;

    @Column(name= "titular", nullable = false, length = 40)
    private String titular;

    @Column(name= "numhabitantes", nullable = false, length = 2)
    private int numHabitantes;

    @ManyToOne
    @JoinColumn(name = "barrio_id", nullable = false)
    private BarrioModelo barrio;

    public ViviendaModelo(int id, String calle, int nro, String titular, int numHabitantes, BarrioModelo barrio){
        this.id = id;
        this.calle = calle;
        this.nro = nro;
        this.titular = titular;
        this.numHabitantes = numHabitantes;
        this.barrio = barrio;
    }

    //Sin un constructor vacío Hibernate tira error
    public ViviendaModelo(){};

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setCalle(String calle){
        this.calle = calle;
    }

    public String getCalle(){
        return this.calle;
    }

    public void setNro(int nro){
        this.nro = nro;
    }

    public int getNro(){
        return this.nro;
    }

    public void setTitular(String titular){
        this.titular = titular;
    }

    public String getTitular(){
        return this.titular;
    }

    public void setNumHabitantes(int numHabitantes){
        this.numHabitantes = numHabitantes;
    }

    public int getNumHabitantes(){
        return this.numHabitantes;
    }

    public BarrioModelo getBarrio(){
        return this.barrio;
    }
    
    public void setBarrio(BarrioModelo barrio){
        this.barrio = barrio;
    }
}
