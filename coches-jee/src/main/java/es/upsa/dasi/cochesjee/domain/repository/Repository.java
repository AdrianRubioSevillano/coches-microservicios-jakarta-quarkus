package es.upsa.dasi.cochesjee.domain.repository;


import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;

import java.util.List;
import java.util.Optional;

public interface Repository {
    List<Coche> findAllCoches();
    Optional<Coche> findById(long id);
    Coche insertCoche(Coche coche);
    void updateCoche(Coche coche) throws NotFoundCochesException;
    void deleteCoche(long id) throws NotFoundCochesException;
}
