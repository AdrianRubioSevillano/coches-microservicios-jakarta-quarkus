package es.upsa.dasi.cochesjee.application.usecases.impl;

import es.upsa.dasi.cochesjee.application.usecases.FindAllCochesUseCase;
import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.cochesjee.domain.repository.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FindAllCochesUseCaseImpl implements FindAllCochesUseCase {

    @Inject
    Repository repository;

    @Override
    public List<Coche> findAllCoches() {
        return repository.findAllCoches();
    }
}
