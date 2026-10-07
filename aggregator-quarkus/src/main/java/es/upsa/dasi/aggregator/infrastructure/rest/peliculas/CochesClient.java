package es.upsa.dasi.aggregator.infrastructure.rest.peliculas;


import es.upsa.dasi.aggregator.adapters.rest.dtos.CochePostRequest;
import es.upsa.dasi.aggregator.adapters.rest.dtos.CochePutRequest;
import es.upsa.dasi.aggregator.infrastructure.rest.provider.CochesResponseExceptionMapper;
import es.upsa.dasi.common.adapters.rest.dtos.CocheFullResponse;
import es.upsa.dasi.common.adapters.rest.dtos.CocheResponse;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;


@RegisterRestClient(configKey = "rest.client.coches")
@RegisterProvider(CochesResponseExceptionMapper.class)
public interface CochesClient {

    @GET
    @Path("/coches")
    @Produces(MediaType.APPLICATION_JSON)
    List<CocheResponse> getAllCoches();

    @GET
    @Path("coches/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    CocheResponse getCoche(@PathParam("id") long id) throws NotFoundCochesException;

    @POST
    @Path("/coches")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CocheFullResponse addCoche(CochePostRequest coche);

    @PUT
    @Path("/coches/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void updateCoche(@PathParam("id") long id, CochePutRequest coche) throws NotFoundCochesException;

    @DELETE
    @Path("/coches/{id}")
    void deleteCoche(@PathParam("id") long id) throws NotFoundCochesException;



}
