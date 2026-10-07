package es.upsa.dasi.cochesjee.adapters.rest;


import es.upsa.dasi.cochesjee.adapters.rest.dtos.CochePostrequest;
import es.upsa.dasi.cochesjee.adapters.rest.dtos.CochePutRequest;
import es.upsa.dasi.cochesjee.application.usecases.*;
import es.upsa.dasi.cochesjee.domain.model.AddCocheCommand;
import es.upsa.dasi.cochesjee.domain.model.ReplaceCocheCommand;
import es.upsa.dasi.common.adapters.rest.dtos.CocheFullResponse;
import es.upsa.dasi.common.adapters.rest.dtos.CocheResponse;
import es.upsa.dasi.cochesjee.adapters.rest.mappers.ResourceMapper;
import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.inject.Inject;
import jakarta.validation.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Path("/coches")
public class CocheResource {

    FindAllCochesUseCase findAllCochesUseCase;
    FindcocheByIdUseCase findcocheByIdUseCase;
    InsertCocheUseCase insertCocheUseCase;
    UpdateCocheUseCase updateCocheUseCase;
    DeleteUseCase deleteUseCase;

    ResourceMapper resourceMapper;
    Validator validator;

    @Inject
    public CocheResource(FindAllCochesUseCase findAllCochesUseCase, FindcocheByIdUseCase findcocheByIdUseCase, InsertCocheUseCase insertCocheUseCase, UpdateCocheUseCase updateCocheUseCase, DeleteUseCase deleteUseCase, ResourceMapper resourceMapper, Validator validator) {
        this.findAllCochesUseCase = findAllCochesUseCase;
        this.findcocheByIdUseCase = findcocheByIdUseCase;
        this.insertCocheUseCase = insertCocheUseCase;
        this.updateCocheUseCase = updateCocheUseCase;
        this.deleteUseCase = deleteUseCase;
        this.resourceMapper = resourceMapper;
        this.validator = validator;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllCoches() {
        List<Coche> allCoches = findAllCochesUseCase.findAllCoches();
        List<CocheResponse> list = allCoches.stream().map(resourceMapper::toCocheResponse).toList();
        return Response.ok().entity(list).build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCoche(@PathParam("id") long id, @Context UriInfo uriInfo) throws NotFoundCochesException {

        Optional<Coche> cocheById = findcocheByIdUseCase.findCocheById(id);
        return cocheById.map(coche -> resourceMapper.toCocheFullResponse(coche, uriInfo))
                .map(cocheFullResponse -> Response.ok().entity(cocheFullResponse).build())
                .orElseThrow(()-> new NotFoundCochesException("No se ha encontrado la persona con ese ID"));
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertCoche(CochePostrequest cochePostrequest, @Context UriInfo uriInfo){

        Set<ConstraintViolation<CochePostrequest>> validate = validator.validate(cochePostrequest);
        if(!validate.isEmpty()) throw new ConstraintViolationException(validate);

        AddCocheCommand addCocheCommand = resourceMapper.toAddCocheCommand(cochePostrequest);
        Coche coche = insertCocheUseCase.insertCoche(addCocheCommand);
        CocheFullResponse cocheFullResponse = resourceMapper.toCocheFullResponse(coche, uriInfo);
        return Response.created(cocheFullResponse.getUri()).entity(cocheFullResponse).build();

    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCoche(@PathParam("id") long id,@Valid CochePutRequest cochePutRequest) throws NotFoundCochesException {

        ReplaceCocheCommand replaceCocheCommand = resourceMapper.toReplaceCocheCommand(cochePutRequest);
        updateCocheUseCase.updateCoche(replaceCocheCommand, id);
        return Response.noContent().build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteCoche(@PathParam("id") long id) throws NotFoundCochesException {

        deleteUseCase.deleteCoche(id);
        return Response.noContent().build();

    }
}
