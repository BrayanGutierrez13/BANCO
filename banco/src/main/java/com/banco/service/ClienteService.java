package com.banco.service;

import com.banco.entity.Cliente;
import com.banco.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ClienteService {
    @Inject
    ClienteRepository repository;

    @Transactional
    public void crear(Cliente cliente){
        repository.persist(cliente);
    }

    public List<Cliente> listar(){
        return repository.listAll();
    }

    public Cliente obtenerPorId(Long id){
        return repository.findById(id);
    }
}
