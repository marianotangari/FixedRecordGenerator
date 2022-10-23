package io.github.marianotangari.mocks;

import io.github.marianotangari.annotations.Field;
import io.github.marianotangari.annotations.Record;
import io.github.marianotangari.enums.Alignment;
import io.github.marianotangari.enums.FieldType;

import java.time.LocalDateTime;
import java.util.HashMap;

@Record
public class FirstMockAnnotatedClass {

    @Field(type = FieldType.FIXED_FIELD, ordinal = 1, length = 10, alignment = Alignment.RIGHT)
    private int age;

    @Field(type = FieldType.FIXED_FIELD, ordinal = 2, length = 10, alignment = Alignment.LEFT, padding = '0')
    private boolean isHuman;

    @Field(type = FieldType.FIXED_FIELD, ordinal = 3, length = 10, alignment = Alignment.RIGHT, padding = '$')
    private String name;

    @Field(type = FieldType.FIXED_PATTERN, ordinal = 4, length = 10)
    private String seq;

    @Field(type = FieldType.FIXED_FIELD, ordinal = 5, length = 10)
    private LocalDateTime localDateTime;

    @Field(type = FieldType.FIXED_FIELD, ordinal = 6, length = 10)
    private HashMap<String, String> map;

    public FirstMockAnnotatedClass(int age, boolean isHuman, String name, String seq, LocalDateTime localDateTime) {
        this.age = age;
        this.isHuman = isHuman;
        this.name = name;
        this.seq = seq;
        this.localDateTime = localDateTime;
        this.map = new HashMap<>();
    }
}
