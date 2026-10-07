package es.upsa.dasi.aggregator.adapters.rest.providers;

import es.upsa.dasi.common.adapters.rest.dtos.ErrorReponse;
import es.upsa.dasi.common.domain.exceptions.CochesException;
import es.upsa.dasi.common.domain.exceptions.CochesViolationException;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class CochesExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        ErrorReponse errorResponse = new ErrorReponse();
        return switch (e){

            case NotFoundCochesException notFoundCochesException -> Response.status(Response.Status.NOT_FOUND)
                    .entity(ErrorReponse.builder()
                            .message(e.getMessage())
                            .status("404")
                            .build())
                    .build();
            case CochesViolationException cochesViolationException ->Response.status(Response.Status.BAD_REQUEST)
                    .entity(cochesViolationException.getErrorReponses()).build();
            default -> Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ErrorReponse.builder()
                            .message(e.getMessage())
                            .status("500")
                            .build())
                    .build();

        };
    }
}
