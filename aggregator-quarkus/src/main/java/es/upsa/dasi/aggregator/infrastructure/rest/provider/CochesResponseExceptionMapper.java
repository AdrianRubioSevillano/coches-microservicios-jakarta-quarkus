package es.upsa.dasi.aggregator.infrastructure.rest.provider;

import es.upsa.dasi.common.adapters.rest.dtos.ErrorReponse;
import es.upsa.dasi.common.domain.exceptions.CochesException;
import es.upsa.dasi.common.domain.exceptions.CochesViolationException;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class CochesResponseExceptionMapper implements ResponseExceptionMapper<CochesException> {
    @Override
    public CochesException toThrowable(Response response) {
        return switch (response.getStatusInfo().toEnum()){

            case NOT_FOUND -> new NotFoundCochesException(response.readEntity(ErrorReponse.class).getMessage());
            case BAD_REQUEST -> throw new CochesViolationException(response.readEntity(ErrorReponse[].class));
            default -> new CochesException(response.readEntity(ErrorReponse.class).getMessage());

        };
    }
}
