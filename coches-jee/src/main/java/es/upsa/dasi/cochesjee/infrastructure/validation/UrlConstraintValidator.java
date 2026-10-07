package es.upsa.dasi.cochesjee.infrastructure.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.ws.rs.ext.Provider;

import java.net.URI;
import java.net.URL;

public class UrlConstraintValidator implements ConstraintValidator<Url, String> {
    @Override
    public void initialize(Url constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try{
            URI uri = URI.create(s);
            URL url = uri.toURL();
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
