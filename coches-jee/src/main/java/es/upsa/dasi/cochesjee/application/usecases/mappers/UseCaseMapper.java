package es.upsa.dasi.cochesjee.application.usecases.mappers;

import es.upsa.dasi.cochesjee.domain.model.AddCocheCommand;
import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.cochesjee.domain.model.ReplaceCocheCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface UseCaseMapper {
    Coche toCoche(AddCocheCommand command);
    @Mapping(target = "id", source = "id")
    @Mapping(target = ".", source = "command")
    Coche toCoche(ReplaceCocheCommand command, long id);
}
