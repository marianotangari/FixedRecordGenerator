package io.github.marianotangari.record;

import io.github.marianotangari.enums.Alignment;
import io.github.marianotangari.enums.FieldType;
import io.github.marianotangari.mocks.FirstMockAnnotatedClass;
import io.github.marianotangari.mocks.SecondMockAnnotatedClass;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

import static io.github.marianotangari.record.FixedFieldUtils.*;
import static org.junit.Assert.*;

public class FixedFieldUtilsTest {

    private static FirstMockAnnotatedClass firstMockAnnotatedClass;
    private static SecondMockAnnotatedClass secondMockAnnotatedClass;
    private static FixedField fixedFieldMock;

    @Before
    public void setup() {

        firstMockAnnotatedClass = new FirstMockAnnotatedClass(32, true, "Mike", "oki", LocalDateTime.MAX);
        secondMockAnnotatedClass = new SecondMockAnnotatedClass(32);
        fixedFieldMock = new FixedField()
                .withType(FieldType.FIXED_FIELD)
                .withFieldValue("32")
                .withOrdinal(1)
                .withAlignment(Alignment.RIGHT)
                .withLength(10)
                .withPadding(' ');
    }

    @Test
    public void mapFieldToFixedFieldTest() throws NoSuchFieldException, IllegalAccessException {

        Field field = firstMockAnnotatedClass.getClass().getDeclaredField("age");
        field.setAccessible(true);

        FixedField fixedFieldResult = mapFieldToFixedField(field.get(firstMockAnnotatedClass).toString(),
                field.getAnnotation(io.github.marianotangari.annotations.Field.class));

        assertEquals(fixedFieldMock.build(), fixedFieldResult.build());
    }

    @Test
    public void whenIsInvalidClassThenBuildRecordWithFieldName() throws NoSuchFieldException {

        Field field = firstMockAnnotatedClass.getClass().getDeclaredField("localDateTime");
        field.setAccessible(true);

        assertTrue(isValidClass(field));
    }

    @Test
    public void whenIsValidClassThenBuildRecordWithFieldValue() throws NoSuchFieldException {

        Field field = firstMockAnnotatedClass.getClass().getDeclaredField("map");
        field.setAccessible(true);

        assertFalse(isValidClass(field));
    }

    @Test
    public void getSortedAnnotatedFieldsTest() {

        List<FixedField> result = getSortedAnnotatedFields(secondMockAnnotatedClass);
        assertEquals(1, result.size());
        assertEquals("32", result.get(0).getFieldValue());
    }
}
