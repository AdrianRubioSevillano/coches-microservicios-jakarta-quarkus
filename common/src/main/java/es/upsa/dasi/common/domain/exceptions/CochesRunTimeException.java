package es.upsa.dasi.common.domain.exceptions;

public class CochesRunTimeException extends RuntimeException {
    public CochesRunTimeException() {
    }

    public CochesRunTimeException(String message) {
        super(message);
    }

    public CochesRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CochesRunTimeException(Throwable cause) {
        super(cause);
    }

    public CochesRunTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
