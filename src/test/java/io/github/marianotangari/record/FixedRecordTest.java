package io.github.marianotangari.record;

import io.github.marianotangari.exception.RecordAnnotationNotFound;
import io.github.marianotangari.mocks.FirstMockAnnotatedClass;
import io.github.marianotangari.mocks.ThirdMockAnnotatedClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FixedRecordTest {

    @Test
    public void getRecordTest() {
        FirstMockAnnotatedClass firstMockAnnotatedClass = new FirstMockAnnotatedClass(32, true, "Mike", "ok", LocalDateTime.MAX);

        FixedRecord result = FixedRecord.of(firstMockAnnotatedClass);
        assertEquals("        32true000000$$$$$$Mikeokokokokok+999999999       map", result.getRecord());
    }

    @Test
    public void whenRecordAnnotationNotFoundThrowException() {
        assertThrows(RecordAnnotationNotFound.class, () -> FixedRecord.of(new ThirdMockAnnotatedClass(32)));
    }
}
