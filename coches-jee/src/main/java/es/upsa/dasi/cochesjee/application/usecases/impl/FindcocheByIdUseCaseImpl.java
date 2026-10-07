package es.upsa.dasi.cochesjee.application.usecases.impl;

import es.upsa.dasi.cochesjee.application.usecases.FindcocheByIdUseCase;
import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.cochesjee.domain.repository.Repository;
import es.upsa.dasi.cochesjee.infrastructure.persistance.dao.dtos.CocheRow;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class FindcocheByIdUseCaseImpl implements FindcocheByIdUseCase {

    @Inject
    Repository repository;

    @Override
    public Optional<Coche> findCocheById(long id) {
        return repository.findById(id);
    }
}
