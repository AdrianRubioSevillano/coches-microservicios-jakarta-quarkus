package es.upsa.dasi.cochesjee.application.usecases;

import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.cochesjee.infrastructure.persistance.dao.dtos.CocheRow;

import java.util.Optional;

public interface FindcocheByIdUseCase {
    Optional<Coche> findCocheById(long id);
}
