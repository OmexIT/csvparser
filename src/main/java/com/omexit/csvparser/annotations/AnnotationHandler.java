package com.omexit.csvparser.annotations;

import com.omexit.csvparser.exceptions.ValidationException;

import java.lang.reflect.Field;

public class AnnotationHandler {

    public void handle(Object ob) throws Exception {
        Field[] fields = ob.getClass().getDeclaredFields();
//        System.err.println("here: "+ fields.length);
//        System.err.println("Object: "+ ob.getClass().getDeclaredFields().length);
        for (Field field : fields) {
            System.err.println("here");
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                System.err.println("NotNull");
                NotNull notNull = field.getAnnotation(NotNull.class);
                if (field.get(ob) == null) {
                    throw new ValidationException(notNull.message());
                }
            }
            if (field.isAnnotationPresent(MinLen.class)) {
                System.err.println("MinLen");
                MinLen minLen = field.getAnnotation(MinLen.class);
                if (field.get(ob).toString().length() < minLen.len()) {
                    throw new ValidationException(minLen.message());
                }
            }
            if (field.isAnnotationPresent(MaxLen.class)) {
                System.err.println("MaxLen");
                MaxLen maxLen = field.getAnnotation(MaxLen.class);
                System.err.println("maxLen: " + maxLen.len());
                System.err.println("len: " + field.get(ob).toString().length());
                if (field.get(ob).toString().length() > maxLen.len()) {
                    throw new ValidationException(maxLen.message());
                }
            }
            if (field.isAnnotationPresent(Regex.class)) {
                System.err.println("Regex");
                Regex regex = field.getAnnotation(Regex.class);
                if (field.get(ob).toString().matches(regex.expression())) {
                    throw new ValidationException(regex.message());
                }
            }
        }
    }
}
