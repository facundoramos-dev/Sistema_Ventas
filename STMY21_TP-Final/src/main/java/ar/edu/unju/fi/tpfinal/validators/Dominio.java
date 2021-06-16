package ar.edu.unju.fi.tpfinal.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Constraint(validatedBy = DominioValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Dominio {
    String message() default "Solo se permiten correos con dominio @ejemplo.com";
    Class<?>[] groups() default {};
    Class<? extends Package>[] payload() default {}; 
}
