package io.github.marianotangari.enums;

 public enum ValidClassesEnum {

    NUMBER(Number.class),
    STRING(String.class);

    private final Class<?> clazz;

    ValidClassesEnum(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getValidClass() {
        return this.clazz;
    }
}
