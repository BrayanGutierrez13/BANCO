package com.banco.ClienteCDTDigital.es.resources;

import com.banco.ClienteCDTDigital.es.entity.Cliente;
import com.banco.ClienteCDTDigital.es.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteCDTDigitalResource {

    private static final Logger LOG =
            LoggerFactory.getLogger(ClienteCDTDigitalResource.class);

    @Inject
    ClienteService clienteService;

    // =========================
    // CREATE
    // =========================
    @POST
    public Response crearCliente(Cliente cliente) {
        LOG.info("Inicio crear Cliente");

        try {
            clienteService.crear(cliente);
            LOG.info("Finaliza crear Cliente");
            return Response.status(Response.Status.CREATED)
                    .entity(cliente)
                    .build();
        } catch (Exception e) {
            LOG.error("Error al crear Cliente", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al crear Cliente: " + e.getMessage())
                    .build();
        }
    }

    // =========================
    // READ - LISTAR
    // =========================
    @GET
    public Response listarClientes() {
        LOG.info("Inicio listar Clientes");

        try {
            List<Cliente> clientes = clienteService.listar();
            LOG.info("Finaliza listar Clientes");
            return Response.ok(clientes).build();
        } catch (Exception e) {
            LOG.error("Error al listar Clientes", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al listar Clientes")
                    .build();
        }
    }

    // =========================
    // READ - POR ID
    // =========================
    @GET
    @Path("/{id}")
    public Response obtenerClientePorId(@PathParam("id") Long id) {
        LOG.info("Inicio obtener Cliente por id {}", id);

        try {
            Cliente cliente = clienteService.obtenerPorId(id);

            if (cliente == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            LOG.info("Finaliza obtener Cliente por id");
            return Response.ok(cliente).build();
        } catch (Exception e) {
            LOG.error("Error al obtener Cliente", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener Cliente: " + e.getMessage())
                    .build();
        }
    }

    // =========================
    // UPDATE
    // =========================
    @PUT
    @Path("/{id}")
    public Response actualizarCliente(@PathParam("id") Long id, Cliente cliente) {
        LOG.info("Inicio actualizar Cliente con id {}", id);

        try {
            Cliente actualizado = clienteService.actualizar(id, cliente);

            if (actualizado == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            LOG.info("Finaliza actualizar Cliente");
            return Response.ok(actualizado).build();

        } catch (Exception e) {
            LOG.error("Error al actualizar Cliente", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al actualizar Cliente: " + e.getMessage())
                    .build();
        }
    }

    // =========================
    // DELETE
    // =========================
    @DELETE
    @Path("/{id}")
    public Response eliminarCliente(@PathParam("id") Long id) {
        LOG.info("Inicio eliminar Cliente con id {}", id);

        try {
            boolean eliminado = clienteService.eliminar(id);

            if (!eliminado) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            LOG.info("Finaliza eliminar Cliente");
            return Response.noContent().build();

        } catch (Exception e) {
            LOG.error("Error al eliminar Cliente", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al eliminar Cliente: " + e.getMessage())
                    .build();
        }
    }
}
