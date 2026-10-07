package es.upsa.dasi.cochesjee.application.usecases;

import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.cochesjee.domain.model.ReplaceCocheCommand;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;

public interface UpdateCocheUseCase {
    void updateCoche(ReplaceCocheCommand command, long id) throws NotFoundCochesException;
}
