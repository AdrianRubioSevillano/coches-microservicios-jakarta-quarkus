package es.upsa.dasi.cochesjee.infrastructure.persistance.dao.mappers;

import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.cochesjee.infrastructure.persistance.dao.dtos.CocheRow;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface DaoMapper {
    CocheRow toCocheRow(Coche coche);
    Coche toCoche(CocheRow coche);
}
