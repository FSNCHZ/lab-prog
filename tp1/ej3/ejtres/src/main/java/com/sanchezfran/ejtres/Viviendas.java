package com.sanchezfran.ejtres;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "viviendass")
public class Viviendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="calle", nullable=false, length=50)
    private String calle;

    @Column(length=5)
    private int nro;

    @Column(name="titular", nullable=false, length=40)
    private String titular;

    @Column(name="habitantes", length=2)
    private int habitantes;
}
