package com.banco.service;

import com.banco.entity.Cliente;
import java.util.List;

public interface ClienteService {

    void crear(Cliente cliente);

    List<Cliente> listar();

    Cliente obtenerPorId(Long id);
}
