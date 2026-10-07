package es.upsa.dasi.cochesjee.application.usecases;

import es.upsa.dasi.cochesjee.domain.model.Coche;

import java.util.List;

public interface FindAllCochesUseCase {
    List<Coche> findAllCoches();
}
