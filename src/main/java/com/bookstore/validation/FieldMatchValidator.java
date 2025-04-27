package com.bookstore.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Field firstField = object.getClass().getDeclaredField(firstFieldName);
            firstField.setAccessible(true);
            Object firstValue = firstField.get(object);

            Field secondField = object.getClass().getDeclaredField(secondFieldName);
            secondField.setAccessible(true);
            Object secondValue = secondField.get(object);

            return firstValue != null && firstValue.equals(secondValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return false;
        }
    }
}
