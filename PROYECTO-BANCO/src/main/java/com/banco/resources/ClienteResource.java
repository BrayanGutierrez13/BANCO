package com.banco.resources;

import com.banco.entity.Cliente;
import com.banco.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    // Crear cliente
    @POST
    public Response crearCliente(Cliente cliente) {
        clienteService.crear(cliente);
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }

    // Listar todos los clientes
    @GET
    public Response listarClientes() {
        List<Cliente> clientes = clienteService.listar();
        return Response.ok(clientes).build();
    }

    // Obtener cliente por ID
    @GET
    @Path("/{id}")
    public Response obtenerClientePorId(@PathParam("id") Long id) {
        Cliente cliente = clienteService.obtenerPorId(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cliente).build();
    }
}
