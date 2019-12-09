package com.omexit.csvparser.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullValidator implements ConstraintValidator<NotNull, Object> {
    @Override
    public void initialize(NotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return o == null;
    }
}
