package com.omexit.csvparser.exceptions;

public class DateParseException extends RuntimeException{

    public DateParseException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
