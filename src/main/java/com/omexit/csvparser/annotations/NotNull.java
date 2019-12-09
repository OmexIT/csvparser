package com.omexit.csvparser.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {NotNullValidator.class})
public @interface NotNull {
    String message() default  "Should not be null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
