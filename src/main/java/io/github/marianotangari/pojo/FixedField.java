package io.github.marianotangari.pojo;

import io.github.marianotangari.enums.Alignment;
import io.github.marianotangari.enums.FieldType;

public final class FixedField {

    private int ordinal;
    private String fieldValue;
    private FieldType type;
    private int fieldLength;
    private Alignment alignment;
    private char padding;

    int getOrdinal() {
        return ordinal;
    }

    FixedField () {}

    FixedField withOrdinal(int ordinal){
        this.ordinal = ordinal;
        return this;
    }
    
    FixedField withFieldValue(String fieldValue){
        this.fieldValue = fieldValue;
        return this;
    }
    FixedField withType(FieldType type){
        this.type = type;
        return this;
    }
    
    FixedField withLength(int fieldLength){
        this.fieldLength = fieldLength ;
        return this;
    }
    
    FixedField withAlignment(Alignment alignment){
        this.alignment = alignment;
        return this;
    }
    
    FixedField withPadding(char padding){
        this.padding = padding;
        return this;
    }

    public String build() {
        return type == FieldType.FIXED_PATTERN ? buildFixedPatternField() : buildFixedLengthField();
    }
    
    private String buildFixedPatternField() {
        return fieldValue.repeat(fieldLength / fieldValue.length()) + fieldValue.substring(0, fieldLength % fieldValue.length());
    }
    
    private String buildFixedLengthField() {
        
        int paddingLength = Math.max(fieldLength - fieldValue.length(), 0);

        fieldValue = paddingLength == 0 ? fieldValue.substring(0, fieldLength) : fieldValue;

        return alignment == Alignment.RIGHT ? String.valueOf(padding).repeat(paddingLength) + fieldValue : fieldValue + String.valueOf(padding).repeat(paddingLength);
    }

    @Override
    public String toString() {
        return String.format("ordinal = %d, fieldValue = %s, fieldLength = %d, type = %s, alignment = %s, padding = %c",
                ordinal, fieldValue, fieldLength, type.name(), alignment.name(), padding);
    }
}
