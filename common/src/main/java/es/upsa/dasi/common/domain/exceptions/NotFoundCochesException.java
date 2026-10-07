package es.upsa.dasi.common.domain.exceptions;

public class NotFoundCochesException extends CochesException {

    public NotFoundCochesException(String message) {
        super("No se ha encontrado el Id.");
    }
}
