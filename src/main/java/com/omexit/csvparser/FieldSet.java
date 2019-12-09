package com.omexit.csvparser;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class FieldSet {

    private String[] parts;

    private NumberFormat numberFormat;

    public FieldSet(String[] parts) {
        this.parts = parts;
        this.numberFormat = NumberFormat.getInstance(Locale.US);
    }

    public String readString(int index) {
        return this.readAndTrim(index);
    }

    /***
     * Read date using a date format
     * @param index index of the value in the array
     * @param dateFormat Date format to be used
     * @return
     */
    public Date readDate(int index, DateFormat dateFormat) {
        String part = this.readAndTrim(index);
        try {
            return dateFormat.parse(part);
        } catch (ParseException e) {
            throw new DateParseException(String.format("Could not parse: %s to date", parts), e);
        }
    }

    /***
     * Read int value
     * @param index index of the value in the array
     * @return
     */
    public int readInt(int index) {
        return this.parseNumber(this.readAndTrim(index)).intValue();
    }

    /***
     * Read long value
     *
     * @param index index of the value in the array
     * @return
     */
    public long readLong(int index) {
        return this.parseNumber(this.readAndTrim(index)).longValue();
    }

    /***
     * Read float value
     * @param index
     * @return
     */
    public float readFloat(int index) {
        return this.parseNumber(this.readAndTrim(index)).floatValue();
    }

    /***
     * Read double value
     * @param index index of the value in the array
     * @return
     */
    public double readDouble(int index) {
        return this.parseNumber(this.readAndTrim(index)).doubleValue();
    }

    /***
     * Convert from string to number
     * @param part index of the value in the array
     * @return
     */
    private Number parseNumber(String part) {
        try {
            return this.numberFormat.parse(part);
        } catch (ParseException e) {
            throw new NumberFormatException(String.format("Could not parse: %s to number", part));
        }
    }

    /**
     * Read string and trim extra space
     * @param index index of the value in the array
     * @return
     */
    protected String readAndTrim(int index) {
        String value = this.parts[index];
        return value != null ? value.trim() : null;
    }
}
