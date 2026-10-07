package es.upsa.dasi.cochesjee.adapters.rest.providers;

import es.upsa.dasi.common.adapters.rest.dtos.ErrorReponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Set;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(constraintViolations.stream()
                        .map(constraintViolation -> ErrorReponse.builder()
                                .message(constraintViolation.getMessage())
                                .status(constraintViolation.getPropertyPath().toString())
                                .build())
                        .toList())
                .build();
    }
}
