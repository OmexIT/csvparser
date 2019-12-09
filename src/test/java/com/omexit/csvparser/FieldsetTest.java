package com.omexit.csvparser;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FieldsetTest {
    static FieldSet fieldSet;

    @BeforeClass
    public static void setUp() throws Exception {
        String line = "3,Test Three,11-08-1996,112233144554544,1.8,84.000412";
        fieldSet = new FieldSet(line.split(","));
    }

    @Test
    public void testReadString() {
        String readString = fieldSet.readString(1);
        assertEquals("Test Three", readString);
    }

    @Test
    public void testReadInt() {
        int readInt = fieldSet.readInt(0);
        assertEquals(3, readInt);
    }

    @Test
    public void testReadDate() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date readDate = fieldSet.readDate(2, dateFormat);
        assertEquals(dateFormat.parse("11-08-1996"), readDate);
    }

    @Test
    public void testReadLong() {
        long readLong = fieldSet.readLong(3);
        assertEquals(112233144554544L, readLong);
    }

    @Test
    public void testReadFloat() {
        float readFloat = fieldSet.readFloat(4);
        assertEquals(1.8f, readFloat,0);
    }

    @Test
    public void testReadDouble() {
        double readDouble = fieldSet.readDouble(5);
        assertEquals(84.000412, readDouble,0);
    }
}
