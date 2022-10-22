package io.github.marianotangari.annotations;

import io.github.marianotangari.enums.Alignment;
import io.github.marianotangari.enums.FieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Field {

    FieldType type();
    int ordinal();
    int length();
    Alignment alignment() default Alignment.RIGHT;
    char padding() default ' ';
}
