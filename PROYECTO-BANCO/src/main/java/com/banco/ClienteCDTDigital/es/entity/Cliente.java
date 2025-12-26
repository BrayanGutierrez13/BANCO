package com.banco.ClienteCDTDigital.es.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
public class Cliente extends PanacheEntity {

    @Column(nullable = false, length = 100)
    public String nombre;

    @Column(nullable = false, length = 30, unique = true)
    public String documento;
}
