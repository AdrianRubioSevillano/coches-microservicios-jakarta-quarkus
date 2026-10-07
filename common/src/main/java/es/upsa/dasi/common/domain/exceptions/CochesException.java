package es.upsa.dasi.common.domain.exceptions;

public class CochesException extends Exception{
    public CochesException() {
    }

    public CochesException(String message) {
        super(message);
    }

    public CochesException(String message, Throwable cause) {
        super(message, cause);
    }

    public CochesException(Throwable cause) {
        super(cause);
    }

    public CochesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
