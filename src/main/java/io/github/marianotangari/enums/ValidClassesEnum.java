package io.github.marianotangari.enums;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public enum ValidClassesEnum {

    NUMBER(Number.class),
    STRING(String.class),
    LOCAL_DATE(LocalDate.class),
    LOCAL_TIME(LocalTime.class),
    LOCAL_DATE_TIME(LocalDateTime.class);

    private final Class<?> clazz;

    ValidClassesEnum(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getValidClass() {
        return this.clazz;
    }
}
