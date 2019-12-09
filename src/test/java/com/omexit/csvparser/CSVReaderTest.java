package com.omexit.csvparser;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class CSVReaderTest {
    static CSVReader<Employee> csvReader;
    String line = "3,Test Three,11-08-1996";

    @BeforeClass
    public static void setUp() throws Exception {
        csvReader=new CSVReader<Employee>( new EmployeeFieldsetMapper());
    }

    @Test
    public void readLineTest() throws Exception {
        Employee actualEmployee = csvReader.readLine(line);

        Employee employee=new Employee();
        employee.setId(3);
        employee.setName("Test Three");
        employee.setDob(new SimpleDateFormat("dd-MM-yyyy").parse("11-08-1996"));

        assertEquals(employee, actualEmployee);
    }
}
