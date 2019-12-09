package com.omexit.csvparser;

public class DateParseException extends RuntimeException{

    public DateParseException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
