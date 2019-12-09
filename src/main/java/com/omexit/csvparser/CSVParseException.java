package com.omexit.csvparser;

public class CSVParseException extends RuntimeException {
    public CSVParseException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
