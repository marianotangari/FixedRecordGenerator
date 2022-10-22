package io.github.marianotangari.record;

import io.github.marianotangari.annotations.Field;
import io.github.marianotangari.annotations.Record;
import io.github.marianotangari.enums.ValidClassesEnum;
import io.github.marianotangari.exception.RecordAnnotationNotFound;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FixedRecord {

    private final List<FixedField> values;

    public static <T> FixedRecord of(T o) {

        return new FixedRecord(generateFixedFields(o));
    }

    private FixedRecord(List<FixedField> values) {
        this.values = values;
    }

    private static <T> List<FixedField> generateFixedFields(T o) {

        if (!o.getClass().isAnnotationPresent(Record.class))
            throw new RecordAnnotationNotFound();

        return getSortedAnnotatedFields(o);
    }

    public List<FixedField> getFields() {
        return values;
    }

    public String getRecord() {
        return values.stream().map(FixedField::build).collect(Collectors.joining());
    }

    private static <T> List<FixedField> getSortedAnnotatedFields(T o) {

        return Arrays.stream(o.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Field.class))
                .map(field -> FixedFieldMapper.mapFieldToFixedField(getFieldValue(o, field), field.getAnnotation(Field.class)))
                .sorted(Comparator.comparing(FixedField::getOrdinal))
                .collect(Collectors.toList());
    }

    private static <T> String getFieldValue(T o, java.lang.reflect.Field field) {

        field.setAccessible(true);

        boolean isValidClass = Arrays.stream(ValidClassesEnum.values()).anyMatch(i -> i.getValidClass() == (field.getType()))
                || field.getType().isPrimitive();

        if (isValidClass) {
            try {
                return field.get(o).toString();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error Accessing the field's values");
            }
        } else
            return field.getName();
    }
}
