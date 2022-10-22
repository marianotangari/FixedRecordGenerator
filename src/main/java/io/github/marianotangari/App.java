package io.github.marianotangari;

import io.github.marianotangari.record.Example;
import io.github.marianotangari.record.FixedRecord;

import java.time.LocalDate;

public class App
{
    public static void main( String[] args ) {

        Example example = new Example(32, true, "Mike", "oki", LocalDate.MAX);

        FixedRecord fixedRecord = FixedRecord.of(example);

        System.out.println(fixedRecord.getRecord());

       // System.out.println(fixedRecord.getFields());
    }
}
