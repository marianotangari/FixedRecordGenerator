package io.github.marianotangari.record;

import io.github.marianotangari.annotations.Field;

public class FixedFieldMapper {
    
    public static FixedField mapFieldToFixedField(String fieldValue, Field fieldAnnotations) {

        return new FixedField()
                .withType(fieldAnnotations.type())
                .withOrdinal(fieldAnnotations.ordinal())
                .withFieldValue(fieldValue)
                .withAlignment(fieldAnnotations.alignment())
                .withLength(fieldAnnotations.length())
                .withPadding(fieldAnnotations.padding());
    }
}
