
package com.banco.repository;

import com.banco.entity.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
    public Cliente buscarPorId(String documento) {
        return (Cliente)this.find("documento", new Object[]{documento}).firstResult();
    }

    public boolean existePorDocumento(String documento) {
        return this.count("documento", new Object[]{documento}) > 0L;
    }
}
