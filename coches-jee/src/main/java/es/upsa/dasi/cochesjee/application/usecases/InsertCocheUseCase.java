package es.upsa.dasi.cochesjee.application.usecases;

import es.upsa.dasi.cochesjee.domain.model.AddCocheCommand;
import es.upsa.dasi.cochesjee.domain.model.Coche;

public interface InsertCocheUseCase {
    Coche insertCoche(AddCocheCommand command);
}
