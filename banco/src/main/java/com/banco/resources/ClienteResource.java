package com.banco.resources;

import com.banco.dto.ClienteDTO;
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
    public Response create(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.nombre = clienteDTO.nombre;
        cliente.documento = clienteDTO.documento;
        clienteService.crear(cliente);
        return Response.status(Response.Status.CREATED).build();
    }

    // Listar clientes
    @GET
    public List<Cliente> listar(){
        return clienteService.listar();
    }




}
