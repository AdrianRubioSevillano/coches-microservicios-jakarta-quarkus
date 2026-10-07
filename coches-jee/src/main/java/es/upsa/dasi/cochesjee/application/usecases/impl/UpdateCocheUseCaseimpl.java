package es.upsa.dasi.cochesjee.application.usecases.impl;

import es.upsa.dasi.cochesjee.application.usecases.UpdateCocheUseCase;
import es.upsa.dasi.cochesjee.application.usecases.mappers.UseCaseMapper;
import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.cochesjee.domain.model.ReplaceCocheCommand;
import es.upsa.dasi.cochesjee.domain.repository.Repository;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateCocheUseCaseimpl implements UpdateCocheUseCase {

    Repository repository;
    UseCaseMapper mapper;

    @Inject
    public UpdateCocheUseCaseimpl(Repository repository, UseCaseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void updateCoche(ReplaceCocheCommand command, long id) throws NotFoundCochesException {
        Coche coche = mapper.toCoche(command, id);
        repository.updateCoche(coche);
    }
}
