package es.upsa.dasi.cochesjee.application.usecases.impl;

import es.upsa.dasi.cochesjee.application.usecases.InsertCocheUseCase;
import es.upsa.dasi.cochesjee.application.usecases.mappers.UseCaseMapper;
import es.upsa.dasi.cochesjee.domain.model.AddCocheCommand;
import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.cochesjee.domain.repository.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InsertCocheUseCaseImpl implements InsertCocheUseCase {

    Repository repository;
    UseCaseMapper mapper;

    @Inject
    public InsertCocheUseCaseImpl(Repository repository, UseCaseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Coche insertCoche(AddCocheCommand command) {
        Coche coche = mapper.toCoche(command);
        return repository.insertCoche(coche);
    }
}
