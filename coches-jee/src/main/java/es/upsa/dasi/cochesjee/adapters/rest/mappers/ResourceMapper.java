package es.upsa.dasi.cochesjee.adapters.rest.mappers;


import es.upsa.dasi.cochesjee.adapters.rest.dtos.CochePostrequest;
import es.upsa.dasi.cochesjee.adapters.rest.dtos.CochePutRequest;
import es.upsa.dasi.cochesjee.domain.model.AddCocheCommand;
import es.upsa.dasi.cochesjee.domain.model.ReplaceCocheCommand;
import es.upsa.dasi.common.adapters.rest.dtos.CocheFullResponse;
import es.upsa.dasi.common.adapters.rest.dtos.CocheResponse;
import es.upsa.dasi.cochesjee.domain.model.Coche;
import jakarta.ws.rs.core.UriInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.net.URI;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface ResourceMapper {

    CocheResponse toCocheResponse(Coche coche) ;

    @Mapping(target = "uri", expression = "java(createUri(coche, uriInfo))")
    CocheFullResponse toCocheFullResponse(Coche coche, UriInfo uriInfo) ;
    AddCocheCommand toAddCocheCommand(CochePostrequest coche);
    ReplaceCocheCommand toReplaceCocheCommand(CochePutRequest request);

    default URI createUri(Coche coche, UriInfo uriInfo){
        return uriInfo.getBaseUriBuilder()
                .path("/coches/{id}")
                .resolveTemplate("id", coche.getId())
                .build();
    }

}
