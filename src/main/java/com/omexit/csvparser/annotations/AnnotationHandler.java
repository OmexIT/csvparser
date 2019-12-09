package com.omexit.csvparser.annotations;

import com.omexit.csvparser.exceptions.ValidationException;

import java.lang.reflect.Field;

public class AnnotationHandler {

    public void handle(Object ob) throws Exception {
        Field[] fields = ob.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                NotNull notNull = field.getAnnotation(NotNull.class);System.err.println(field.get(ob) == null);
                if (field.get(ob) == null) {
                    throw new ValidationException(notNull.message());
                }
            }
            if (field.isAnnotationPresent(MinLen.class)) {
                MinLen minLen = field.getAnnotation(MinLen.class);
                if (field.get(ob).toString().length() < minLen.len()) {
                    throw new ValidationException(minLen.message());
                }
            }
            if (field.isAnnotationPresent(MaxLen.class)) {
                MaxLen maxLen = field.getAnnotation(MaxLen.class);
                if (field.get(ob).toString().length() > maxLen.len()) {
                    throw new ValidationException(maxLen.message());
                }
            }
            if (field.isAnnotationPresent(Regex.class)) {
                Regex regex = field.getAnnotation(Regex.class);
                if (field.get(ob).toString().matches(regex.expression())) {
                    throw new ValidationException(regex.message());
                }
            }
        }
    }
}
