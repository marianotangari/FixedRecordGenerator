package io.github.marianotangari.record;

import io.github.marianotangari.annotations.Field;
import io.github.marianotangari.enums.Alignment;
import io.github.marianotangari.enums.FieldType;
import io.github.marianotangari.annotations.Record;

import java.time.LocalDate;

@Record
public class Example {

    @Field(type = FieldType.FIXED_FIELD, ordinal = 1, length = 10, alignment = Alignment.RIGHT)
    private int age;

    @Field(type = FieldType.FIXED_FIELD, ordinal = 2, length = 10, alignment = Alignment.LEFT, padding = 'o')
    private boolean isHuman;

    @Field(type = FieldType.FIXED_FIELD, ordinal = 3, length = 10, alignment = Alignment.LEFT, padding = '$')
    private String name;

    @Field(type = FieldType.FIXED_PATTERN, ordinal = 4, length = 10)
    private String seq;

    @Field(type = FieldType.FIXED_FIELD, ordinal = 5, length = 10)
    private LocalDate localDate;

    public Example(int age, boolean isHuman, String name, String seq, LocalDate localDate) {
        this.age = age;
        this.isHuman = isHuman;
        this.name = name;
        this.seq = seq;
        this.localDate = localDate;
    }
}
