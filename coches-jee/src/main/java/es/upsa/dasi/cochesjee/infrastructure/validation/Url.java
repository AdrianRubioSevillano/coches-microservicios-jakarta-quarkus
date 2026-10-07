package es.upsa.dasi.cochesjee.infrastructure.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {UrlConstraintValidator.class})
@Target({ElementType.FIELD,
ElementType.PARAMETER,})
@Retention(RetentionPolicy.RUNTIME)
public @interface Url {

    public String message() default "{es.upsa.dasi.cochesjee.infrastructure.validation.Url.message}";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};

}
