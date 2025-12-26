package com.banco.ClienteCDTDigital.es.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Cuenta extends PanacheEntity {
    public String numeroCuenta;
    public double saldo;
    @ManyToOne
    public Cliente cliente;
}
