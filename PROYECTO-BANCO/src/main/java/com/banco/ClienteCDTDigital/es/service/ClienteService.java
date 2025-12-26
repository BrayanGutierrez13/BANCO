package com.banco.ClienteCDTDigital.es.service;

import com.banco.ClienteCDTDigital.es.entity.Cliente;
import java.util.List;

public interface ClienteService {

    void crear(Cliente cliente);

    List<Cliente> listar();

    Cliente obtenerPorId(Long id);

    Cliente actualizar(Long id, Cliente cliente);

    boolean eliminar(Long id);
}

