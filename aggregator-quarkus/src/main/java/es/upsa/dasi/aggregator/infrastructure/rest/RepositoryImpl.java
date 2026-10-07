package es.upsa.dasi.aggregator.infrastructure.rest;

import es.upsa.dasi.aggregator.adapters.rest.dtos.CochePostRequest;
import es.upsa.dasi.aggregator.adapters.rest.dtos.CochePutRequest;
import es.upsa.dasi.aggregator.domain.repository.Repository;
import es.upsa.dasi.aggregator.infrastructure.rest.peliculas.CochesClient;
import es.upsa.dasi.common.adapters.rest.dtos.CocheFullResponse;
import es.upsa.dasi.common.adapters.rest.dtos.CocheResponse;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;


@ApplicationScoped
public class RepositoryImpl implements Repository
{

    @RestClient
    @Inject
    CochesClient cochesClient;

    @Override
    public List<CocheResponse> getAllCoches() {
        return cochesClient.getAllCoches();
    }

    @Override
    public CocheResponse getCoche(long id) throws NotFoundCochesException {
        return cochesClient.getCoche(id);
    }

    @Override
    public CocheFullResponse insertCoche(CochePostRequest coche) {
        return cochesClient.addCoche(coche);
    }

    @Override
    public void updateCoche(long id, CochePutRequest coche) throws NotFoundCochesException {
        cochesClient.updateCoche(id, coche);
    }

    @Override
    public void deleteCoche(long id) throws NotFoundCochesException {
        cochesClient.deleteCoche(id);
    }
}
