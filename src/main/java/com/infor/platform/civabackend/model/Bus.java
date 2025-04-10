package com.infor.platform.civabackend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroBus;
    private String placa;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    private String caracteristicas;

    @ManyToOne
    @JoinColumn(name = "marca_id") // clave foránea
    private Marca marca;

    private boolean activo;

    // Constructores
    public Bus() {
    }

    public Bus(String numeroBus, String placa, String caracteristicas, Marca marca, boolean activo) {
        this.numeroBus = numeroBus;
        this.placa = placa;
        this.caracteristicas = caracteristicas;
        this.marca = marca;
        this.activo = activo;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public String getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(String numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
