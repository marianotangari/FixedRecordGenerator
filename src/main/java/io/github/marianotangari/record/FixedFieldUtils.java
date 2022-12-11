package io.github.marianotangari.record;

import io.github.marianotangari.annotations.Field;
import io.github.marianotangari.enums.ValidClassesEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedFieldUtils {
    
    static FixedField mapFieldToFixedField(String fieldValue,Field fieldAnnotations) {

        return new FixedField()
                .withType(fieldAnnotations.type())
                .withOrdinal(fieldAnnotations.ordinal())
                .withFieldValue(fieldValue)
                .withAlignment(fieldAnnotations.alignment())
                .withLength(fieldAnnotations.length())
                .withPadding(fieldAnnotations.padding());
    }

    static boolean isValidClass(java.lang.reflect.Field field) {
        return Arrays.stream(ValidClassesEnum.values()).anyMatch(i -> i.getValidClass() == (field.getType()));
    }

    static <T> List<FixedField> getSortedAnnotatedFields(T o) {

        return Arrays.stream(o.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Field.class))
                .map(field -> mapFieldToFixedField(getFieldValue(o, field), field.getAnnotation(Field.class)))
                .sorted()
                .collect(Collectors.toList());
    }

    private static <T> String getFieldValue(T o, java.lang.reflect.Field field) {

        field.setAccessible(true);

        boolean isValidClass = isValidClass(field) || field.getType().isPrimitive();

        if (isValidClass) {
            try {
                return field.get(o).toString();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing the field's values.");
            }
        } else
            return field.getName();
    }
}
