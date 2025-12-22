package com.banco.dto;

import java.math.BigDecimal;

public class ClienteDTO {

    private Long idCliente;
    public String nombre;
    public String documento;

    // Constructor vacío
    public ClienteDTO() {}

    // Constructor con todos los campos
    public ClienteDTO(Long idCliente, String nombre, String apellido, String correo, String telefono, String numeroCuenta, BigDecimal saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.documento = documento;

    }

    // Getters y Setters
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String apellido) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +

                '}';
    }
}
