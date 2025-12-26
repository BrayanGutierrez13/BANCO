package com.banco.ClienteCDTDigital.es.repository;

import com.banco.ClienteCDTDigital.es.entity.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    // CREATE
    public void crear(Cliente cliente) {
        persist(cliente);
    }

    // READ - listar todos
    public List<Cliente> listar() {
        return listAll();
    }

    // READ - por ID
    public Cliente buscarPorId(Long id) {
        return findById(id);
    }

    // READ - por documento
    public Cliente buscarPorDocumento(String documento) {
        return find("documento", documento).firstResult();
    }

    // UPDATE
    public Cliente actualizar(Cliente cliente) {
        return getEntityManager().merge(cliente);
    }

    // DELETE - por ID
    public boolean eliminar(Long id) {
        return deleteById(id);
    }

    // VALIDACIÓN - existe documento
    public boolean existePorDocumento(String documento) {
        return count("documento", documento) > 0;
    }
}
