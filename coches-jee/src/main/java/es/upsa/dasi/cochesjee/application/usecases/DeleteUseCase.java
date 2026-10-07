package es.upsa.dasi.cochesjee.application.usecases;

import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;

public interface DeleteUseCase {
    void deleteCoche(long id) throws NotFoundCochesException;
}
