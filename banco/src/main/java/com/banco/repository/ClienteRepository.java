package com.banco.repository;
import com.banco.entity.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente>{
    // buscar cliente por documento muy usado en banca
    public Cliente buscarPorId(String documento){
        return find("documento",documento).firstResult();
    }

    // verificar si ya existe un cliente
    public boolean existePorDocumento(String documento){
        return count("documento",documento)>0;
    }

}
