package es.upsa.dasi.cochesjee.infrastructure.persistance.dao;

import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.cochesjee.infrastructure.persistance.dao.dtos.CocheRow;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;

import java.util.List;
import java.util.Optional;

public interface Dao {
    List<CocheRow> findAllCoches();
    Optional<CocheRow> findCocheById(long id);
    CocheRow insertCoche(CocheRow coche);
    void updateCoche(CocheRow coche) throws NotFoundCochesException;
    void deleteCoche(long id) throws NotFoundCochesException;
}
