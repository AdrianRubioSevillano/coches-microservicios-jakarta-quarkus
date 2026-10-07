package es.upsa.dasi.aggregator.domain.repository;

import es.upsa.dasi.aggregator.adapters.rest.dtos.CochePostRequest;
import es.upsa.dasi.aggregator.adapters.rest.dtos.CochePutRequest;
import es.upsa.dasi.common.adapters.rest.dtos.CocheFullResponse;
import es.upsa.dasi.common.adapters.rest.dtos.CocheResponse;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.ws.rs.PathParam;

import java.util.List;

public interface Repository {
    List<CocheResponse> getAllCoches();
    CocheResponse getCoche(@PathParam("id") long id) throws NotFoundCochesException;
    CocheFullResponse insertCoche(CochePostRequest coche);
    void updateCoche(@PathParam("id") long id, CochePutRequest coche) throws NotFoundCochesException;
    void deleteCoche(@PathParam("id") long id) throws NotFoundCochesException;
}
