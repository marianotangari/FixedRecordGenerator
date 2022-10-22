package io.github.marianotangari.exception;

public class RecordAnnotationNotFound extends RuntimeException{

    public RecordAnnotationNotFound () {
        super("Annotation @Record not found in class definition.");
    }
}
