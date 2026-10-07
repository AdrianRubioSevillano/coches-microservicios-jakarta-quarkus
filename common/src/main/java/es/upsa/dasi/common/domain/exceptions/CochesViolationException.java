package es.upsa.dasi.common.domain.exceptions;

import es.upsa.dasi.common.adapters.rest.dtos.ErrorReponse;

public class CochesViolationException extends CochesRunTimeException{
    ErrorReponse[] errorReponses;
    public CochesViolationException(ErrorReponse[] errorReponses) {
        this.errorReponses = errorReponses;
    }

    public ErrorReponse[] getErrorReponses() {
        return errorReponses;
    }
}
