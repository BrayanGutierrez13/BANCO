
package com.banco.ClienteCDTDigital.es.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Movimiento extends PanacheEntity {
    public String tipo;
    public Double monto;
    public LocalDateTime fecha;
    @ManyToOne
    public Cuenta cuenta;
}
