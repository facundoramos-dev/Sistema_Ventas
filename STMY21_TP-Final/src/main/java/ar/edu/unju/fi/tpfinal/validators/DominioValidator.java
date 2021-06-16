package ar.edu.unju.fi.tpfinal.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DominioValidator implements ConstraintValidator<Dominio, String>  {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//return (value != null && value.endsWith("fi.unju.edu.ar"));
		return (!value.isEmpty() && value.contains("@") && value.endsWith(".com"));
	}

}
