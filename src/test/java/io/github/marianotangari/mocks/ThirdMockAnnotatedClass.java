package io.github.marianotangari.mocks;

import io.github.marianotangari.annotations.Field;
import io.github.marianotangari.enums.Alignment;
import io.github.marianotangari.enums.FieldType;

public class ThirdMockAnnotatedClass {

    @Field(type = FieldType.FIXED_FIELD, ordinal = 1, length = 10, alignment = Alignment.RIGHT)
    private int age;

    public ThirdMockAnnotatedClass(int age) {
        this.age = age;
    }
}
