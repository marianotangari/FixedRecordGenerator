package io.github.marianotangari.record;

import io.github.marianotangari.annotations.Record;
import io.github.marianotangari.exception.RecordAnnotationNotFound;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.marianotangari.record.FixedFieldUtils.*;

public class FixedRecord {

    private final List<FixedField> values;

    public static <T> FixedRecord of(T o) { return new FixedRecord(generateFixedFields(o)); }

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
}
