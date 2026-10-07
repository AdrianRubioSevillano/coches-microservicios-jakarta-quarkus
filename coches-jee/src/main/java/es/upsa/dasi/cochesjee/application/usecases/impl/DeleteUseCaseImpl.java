package es.upsa.dasi.cochesjee.application.usecases.impl;

import es.upsa.dasi.cochesjee.application.usecases.DeleteUseCase;
import es.upsa.dasi.cochesjee.domain.repository.Repository;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class DeleteUseCaseImpl implements DeleteUseCase {

    @Inject
    Repository repository;
    @Override
    public void deleteCoche(long id) throws NotFoundCochesException {
        repository.deleteCoche(id);
    }
}
