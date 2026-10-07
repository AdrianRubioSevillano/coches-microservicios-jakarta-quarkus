package es.upsa.dasi.cochesjee.infrastructure.persistance.dao;

import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.cochesjee.domain.repository.Repository;
import es.upsa.dasi.cochesjee.infrastructure.persistance.dao.dtos.CocheRow;
import es.upsa.dasi.cochesjee.infrastructure.persistance.dao.mappers.DaoMapper;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class RepositoryImpl implements Repository {

    Dao dao;
    DaoMapper daoMapper;

    @Inject
    public RepositoryImpl(Dao dao, DaoMapper daoMapper) {
        this.dao = dao;
        this.daoMapper = daoMapper;
    }

    @Override
    public List<Coche> findAllCoches() {
        return dao.findAllCoches().stream()
                                    .map(daoMapper::toCoche)
                                    .toList();
    }

    @Override
    public Optional<Coche> findById(long  id) {
        return dao.findCocheById(id).map(daoMapper::toCoche);
    }

    @Override
    public Coche insertCoche(Coche coche) {
        CocheRow cocheRow = daoMapper.toCocheRow(coche);
        CocheRow newCoche = dao.insertCoche(cocheRow);
        return daoMapper.toCoche(newCoche);
    }

    @Override
    public void updateCoche(Coche coche) throws NotFoundCochesException {
        CocheRow cocheRow = daoMapper.toCocheRow(coche);
        dao.updateCoche(cocheRow);
    }

    @Override
    public void deleteCoche(long id) throws NotFoundCochesException {
        dao.deleteCoche(id);

    }
}
