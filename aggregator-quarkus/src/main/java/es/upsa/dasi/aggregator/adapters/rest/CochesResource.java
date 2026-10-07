package es.upsa.dasi.aggregator.adapters.rest;


import es.upsa.dasi.aggregator.adapters.rest.dtos.CochePostRequest;
import es.upsa.dasi.aggregator.adapters.rest.dtos.CochePutRequest;
import es.upsa.dasi.aggregator.domain.repository.Repository;
import es.upsa.dasi.common.adapters.rest.dtos.CocheFullResponse;
import es.upsa.dasi.common.adapters.rest.dtos.CocheResponse;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/coches")
public class CochesResource {

    @Inject
    Repository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCoches() {

        List<CocheResponse> allCoches = repository.getAllCoches();
        return Response.ok().entity(allCoches).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoche(@PathParam("id") long id) throws NotFoundCochesException {

        CocheResponse coche = repository.getCoche(id);
        return Response.ok().entity(coche).build();

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCoche(CochePostRequest coche) {

        CocheFullResponse cocheFullResponse = repository.insertCoche(coche);
        return Response.created(cocheFullResponse.getUri()).entity(cocheFullResponse).build();

    }


    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCoche(@PathParam("id") long id, CochePutRequest coche) throws NotFoundCochesException {

        repository.updateCoche(id, coche);
        return Response.noContent().build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteCoche(@PathParam("id") long id) throws NotFoundCochesException {
        repository.deleteCoche(id);
        return Response.noContent().build();
    }

}
